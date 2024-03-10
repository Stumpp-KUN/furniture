package com.example.furniture.demo.service.impl;

import com.example.furniture.demo.dto.FurnitureDTO;
import com.example.furniture.demo.dto.HoleDTO;
import com.example.furniture.demo.service.PatternService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@RequiredArgsConstructor
public class PatternServiceImpl implements PatternService {
    Double x;
    Double y;
    Double z;

    @Override
    public HoleDTO calculateHoleByPattern(FurnitureDTO furnitureDTO, HoleDTO holeDTO, String code) {
        String[] codeValue = code.split("\\s*\\+\\s*");

        for (String part : codeValue) {
            String[] values = part.split("\\s*([+*/-])\\s*");
            if (values.length != 3) {
                throw new ArithmeticException("Invalid coordinates format");
            }

            Double value = Double.parseDouble(values[0]);
            String operator = values[1];
            String dimension = values[2];

            switch (dimension) {
                case "L":
                    x = applyOperator(furnitureDTO.getLength(), value, operator);
                    break;
                case "B":
                    y = applyOperator(furnitureDTO.getWidth(), value, operator);
                    break;
                case "H":
                    z = applyOperator(furnitureDTO.getHeight(), value, operator);
                    break;
                default:
                    throw new ArithmeticException("Arithmetic operator error");
            }
        }

        holeDTO.setXCoordinate(x);
        holeDTO.setYCoordinate(y);
        holeDTO.setZCoordinate(z);
        return holeDTO;
    }

    private Double applyOperator(Double dimensionValue, Double value, String operator) {
        switch (operator) {
            case "+":
                return dimensionValue + value;
            case "-":
                return dimensionValue - value;
            case "*":
                return dimensionValue * value;
            case "/":
                return dimensionValue / value;
            default:
                throw new ArithmeticException("Arithmetic error: " + operator);
        }
    }
}
