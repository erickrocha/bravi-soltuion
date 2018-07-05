package br.com.bravi;

import org.junit.Assert;
import org.junit.Test;

public class BracketsTest {

    @Test
    public void test_pattern_01(){
        String value = "GIS (Geographic Information System) - {class not qualified} - [longitude, latitude]";
        boolean response = Brackets.isValid(value);
        Assert.assertEquals(true,response);
    }

    @Test
    public void test_pattern_02(){
        String value = "GIS [Geographic Information (System - {class not qualified} - )longitude, latitude] (bakkdjjda) {da,ldkalkda} ";
        boolean response = Brackets.isValid(value);
        Assert.assertEquals(true,response);
    }

    @Test
    public void test_pattern_03(){
        String value = "GIS [Geographic Information System] - {class not qualified - (longitude, latitude)";
        boolean response = Brackets.isValid(value);
        Assert.assertEquals(true,response);
    }

    @Test
    public void test_pattern_04(){
        String value = "GIS [Geographic Information System - {class not qualified - (longitude), latitude]";
        boolean response = Brackets.isValid(value);
        Assert.assertEquals(true,response);
    }
}
