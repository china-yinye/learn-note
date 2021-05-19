package com.xk72.charles.gui.transaction.popups.ZYSRF;

import com.xk72.charles.CharlesContext;
import com.xk72.charles.gui.lib.SsDg;
import com.xk72.charles.gui.transaction.lib.HexAsciiTextPane;
import com.xk72.charles.gui.transaction.popups.HttpUtils;
import com.xk72.charles.gui.transaction.popups.JsonUtils;
import com.xk72.charles.gui.transaction.popups.ResultDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class ZYDecode extends AbstractAction {

    private final Component component;

    protected ZYDecode(Component component){
        super("章鱼（斑马） Decode");
        this.component = component;
    }

    protected abstract String getBody();

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String json = "";
        try{
            String sourceStr = this.getBody();
            String decodeType = "params";
            //FileUtils.writeLog(sourceStr,"zyDecode");
            if (sourceStr.contains("\"code\":")) {
                sourceStr = JsonUtils.getValueByJson(sourceStr);
                decodeType = "code";
            }
            StringBuilder sb = new StringBuilder();
            //decodeType: code or params
            sb.append("{")
                    .append("\"decodeType\"").append(":").append("\"").append(decodeType).append("\"")
                    .append(",")
                    .append("\"param\"").append(":").append("\"").append(sourceStr).append("\"")
                    .append("}");
            //FileUtils.writeLog(sb.toString(),"json");
            json = HttpUtils.doPost("http://49.232.170.172:8002/zyDecode",sb.toString());
            json = JsonUtils.formatJson(json);
        }catch (Exception e){
            CharlesContext.getInstance().error("Fail to decode!");
        }

        new ResultDialog(json);
    }
}
