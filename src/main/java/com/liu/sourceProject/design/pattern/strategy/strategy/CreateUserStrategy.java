package com.liu.sourceProject.design.pattern.strategy.strategy;

import com.liu.sourceProject.design.pattern.strategy.WxWorkCallBack;
import com.liu.sourceProject.design.pattern.strategy.WxWorkCallBackDef;
import com.liu.sourceProject.design.pattern.strategy.annotation.WxWorkChangeType;
import org.springframework.stereotype.Service;


@Service
@WxWorkChangeType(WxWorkCallBackDef.ChangeType.create_user)
public class CreateUserStrategy implements WxWorkAbstractStrategy {
    @Override
    public void process(WxWorkCallBack wxWorkCallBack) {

    }
}
