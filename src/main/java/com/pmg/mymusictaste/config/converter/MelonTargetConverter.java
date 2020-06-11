package com.pmg.mymusictaste.config.converter;

import com.pmg.mymusictaste.util.MelonTarget;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MelonTargetConverter implements Converter<String, MelonTarget> {

    @Override
    public MelonTarget convert(String type) {
        System.out.println(MelonTarget.valueOf(type.toUpperCase()));
        return MelonTarget.valueOf(type.toUpperCase());
    }
    
}
