package com.kaizencode.sensei.converters;

import com.kaizencode.sensei.commands.CategoryCommand;
import com.kaizencode.sensei.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.events.Event;

import static org.junit.jupiter.api.Assertions.*;

class CommandToCategoryTest {

    private final Long ID_VALUE = 1L;
    private final String NAME_VALUE = "Example";

    CommandToCategory converter;

    @BeforeEach
    void setUp() {
        converter = new CommandToCategory();
    }

    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    void convert() {
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setName(NAME_VALUE);

        Category category = converter.convert(categoryCommand);

        assertNotNull(category);
        assertEquals(ID_VALUE, category.getId());
        assertEquals(NAME_VALUE, category.getName());
    }
}