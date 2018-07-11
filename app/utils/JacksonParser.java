package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.AbstractModel;

import java.util.List;

public class JacksonParser {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T extends AbstractModel> AbstractModel parseFromJson(JsonNode json, Class<T> clazz) {
        if(json != null) {
            try {
                return objectMapper.treeToValue(json, clazz);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static JsonNode parseToJson(AbstractModel model) {
        if(model != null) {
            return objectMapper.valueToTree(model);
        }

        return null;
    }

    public static <T extends AbstractModel> JsonNode parseToJson(List<T> models) {
        if(models != null) {
            return objectMapper.valueToTree(models);
        }

        return null;
    }
}
