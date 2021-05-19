package com.xk72.charles.gui.transaction.popups;

import com.xk72.charles.CharlesContext;
import com.xk72.charles.gui.lib.SsDg;
import com.xk72.charles.gui.transaction.lib.HexAsciiTextPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class CKDecode extends AbstractAction {

    private final Component component;

    protected CKDecode(Component component){
        super("刺客 log Decode");
        this.component = component;
    }

    protected abstract String getBody();

    public void actionPerformed(ActionEvent actionEvent){
        String json = "";
        String sourceJson = this.getBody();
        try{
            if (sourceJson.contains(":") && sourceJson.contains("{")){
                sourceJson = JsonUtils.getValueByJson(sourceJson);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("{").append("\"code\"").append(":\"").append(sourceJson).append("\"}");
            json = HttpUtils.doPost("http://49.232.170.172:8002/ckDecode",sb.toString());
            json = JsonUtils.formatJson(json);
        }catch (Exception e){
            CharlesContext.getInstance().error("Fail to show json");
        }

        new ResultDialog(json);
    }

}
