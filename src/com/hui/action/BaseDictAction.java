package com.hui.action;

import com.hui.domain.BaseDict;
import com.hui.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
    //basedict的模型
    private BaseDict baseDict=new BaseDict();
    @Override
    public BaseDict getModel() {
        return baseDict;
    }

    private BaseDictService baseDictService;

    public void setBaseDictService(BaseDictService baseDictService) {
        this.baseDictService = baseDictService;
    }

    public String findByCode() throws IOException {
        //根据ajax发来的数据进行查询
        List<BaseDict> list = baseDictService.findByCode(baseDict.getDict_type_code());
        //将无用的数据剔除
        JsonConfig jsonConfig=new JsonConfig();
        jsonConfig.setExcludes(new String[]{"dict_sort","dict_enable","dict_memo"});
        //转换为jSON的格式
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        //通过reponse输出到页面
        //System.out.println(jsonArray.toString());
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().println(jsonArray.toString());

        return NONE;
    }
}
