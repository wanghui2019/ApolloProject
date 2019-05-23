package com.hui.action;

import com.hui.domain.Customer;
import com.hui.domain.PageBeans;
import com.hui.service.CustomerService;
import com.hui.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.File;
import java.io.IOException;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer=new Customer();
    //得到封装好的客户模型
    @Override
    public Customer getModel() {
        return customer;
    }

    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    //当前页
    private int currPage=1;

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    //第几页
    private int showNum=3;

    public void setShowNum(int showNum) {
        this.showNum = showNum;
    }

    //获取文件上传来的数据
    private String uploadFileName;

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    private File upload;

    public void setUpload(File upload) {
        this.upload = upload;
    }

    private String uploadContentType;

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    //保存用户
    public String save() throws IOException {
        //获取具有唯一标识的字符串
        String newName = UploadUtils.getUUID(uploadFileName);
        //获取文件夹的字符串
        String dirs = UploadUtils.getDirs(newName);
        //拼接一个到本地计算机的字符串路径
        String root="/Users/wanghui/Desktop/file";
        String url=root+dirs;
        //创建一个文件夹路径
        File dirsUrl=new File(url);
        //判断是否存在这个文件夹路径，不存在就创建
        if (!dirsUrl.exists()){
            dirsUrl.mkdirs();
        }
        //拼接文件的路径,并创建对象
        File fileUrl=new File(url+"/"+newName);
        //将文件内容复制到这个路径下
        FileUtils.copyFile(upload,fileUrl);

        //将文件的名称存到数据库里
        customer.setCust_image(url+"/"+newName);
        customerService.save(customer);
        return "successSave";
    }

    //获取分页查询用户信息
    public String findByPage(){
        //创建条件对象
        DetachedCriteria detachedCriteria= DetachedCriteria.forClass(Customer.class);
        //设置查询条件
        if (customer.getCust_name()!=null && !"".equals(customer.getCust_name())){
            //根据名称的搜索模糊查询
            detachedCriteria.add(Restrictions.like("cust_name","%"+customer.getCust_name().trim()+"%"));
        }
        //先判断数据字典有没有值，再判断对应的数据字典的id存不存在
        if (customer.getBaselevel()!=null){
            //因为这时的customer.getBaselevel()如果为空，null是不能.getDict_id()的，所以上面的if才要判断一下
            if (customer.getBaselevel().getDict_id()!=null && !"".equals(customer.getBaselevel().getDict_id())){
                detachedCriteria.add(Restrictions.eq("baselevel.dict_id",customer.getBaselevel().getDict_id()));
            }
        }

        if (customer.getBasesource()!=null){
            //因为这时的customer.getBaselevel()如果为空，null是不能.getDict_id()的，所以上面的if才要判断一下
            if (customer.getBasesource().getDict_id()!=null && !"".equals(customer.getBasesource().getDict_id())){
                detachedCriteria.add(Restrictions.eq("basesource.dict_id",customer.getBasesource().getDict_id()));
            }
        }

        if (customer.getBaseindustry()!=null){
            //因为这时的customer.getBaselevel()如果为空，null是不能.getDict_id()的，所以上面的if才要判断一下
            if (customer.getBaseindustry().getDict_id()!=null && !"".equals(customer.getBaseindustry().getDict_id())){
                detachedCriteria.add(Restrictions.eq("baseindustry.dict_id",customer.getBaseindustry().getDict_id()));
            }
        }
        //调用业务层的方法获取返回的分页类
        PageBeans<Customer> pageBeans=customerService.findByPage(detachedCriteria,currPage,showNum);
        //压入ValueStack
        ActionContext.getContext().getValueStack().push(pageBeans);
        return "findByPage";
    }


    //删除用户
    public String deleteCustomer(){
        customer= customerService.findByID(customer.getCust_id());
        //查询到之后开始删除,先把客户上传的文件删除
        if (customer.getCust_image()!=null){
            File file=new File(customer.getCust_image());
            System.out.println(file.getAbsolutePath());
            if (file.exists()){
                file.delete();
            }
        }
        //删除客户
        customerService.delete(customer);
        return "deleteSuccess";
    }
    //回显数据
    public String edit(){
        //根据id查询客户信息
        customer=customerService.findByID(customer.getCust_id());
        //将查询到的customer封装到valueStack里
        ActionContext.getContext().getValueStack().push(customer);

        return "editSuccess";
    }
    //修改客户信息
    public String update() throws IOException {
        //数据更新前，把以前存的文件删除，再把新的文件保存,回显只回显了路径，并没有文件
        //1.显判断客户有没有修改文件
        if (upload!=null){
            //客户已经修改了文件，先把以前的文件和路径删除，再添加新的文件进去
            String cust_image=customer.getCust_image();
            //判断一下，如果文件不为空，就删除
            if (cust_image!=null || "".equals(cust_image)){
                File file=new File(cust_image);
                file.delete();
            }
            //添加新的文件
            //获取具有唯一标识的字符串
            String newName = UploadUtils.getUUID(uploadFileName);
            //获取文件夹的字符串
            String dirs = UploadUtils.getDirs(newName);
            //拼接一个到本地计算机的字符串路径
            String root="/Users/wanghui/Desktop/file";
            String url=root+dirs;
            //创建一个文件夹路径
            File dirsUrl=new File(url);
            //判断是否存在这个文件夹路径，不存在就创建
            if (!dirsUrl.exists()){
                dirsUrl.mkdirs();
            }
            //拼接文件的路径,并创建对象
            File fileUrl=new File(url+"/"+newName);
            //将文件内容复制到这个路径下
            FileUtils.copyFile(upload,fileUrl);

            //将文件的名称存到数据库里
            customer.setCust_image(url+"/"+newName);
        }

        //System.out.println(customer.toString());
        customerService.update(customer);
        return "successUpdate";
    }

}
