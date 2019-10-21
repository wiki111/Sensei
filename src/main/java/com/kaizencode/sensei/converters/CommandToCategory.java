package com.kaizencode.sensei.converters;

import com.kaizencode.sensei.commands.CategoryCommand;
import com.kaizencode.sensei.model.Category;
import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommandToCategory implements Converter<CategoryCommand, Category> {
    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand categoryCommand) {
        if(categoryCommand == null){
            return null;
        }
        Category category = new Category();
        category.setId(categoryCommand.getId());
        category.setName(categoryCommand.getName());
        return category;
    }
}
