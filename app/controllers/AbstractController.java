package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.AbstractModel;
import play.mvc.Controller;
import utils.JacksonParser;

import java.util.List;

public class AbstractController extends Controller {

    private Class clazz;

    public <T extends AbstractModel> AbstractController(Class<T> modelClass) {
        this.clazz = modelClass;
    }

    protected AbstractModel getModelFromJson() {
        JsonNode json = request().body().asJson();
        return JacksonParser.parseFromJson(json, clazz);
    }

    protected JsonNode getJsonFromModel(AbstractModel model) {
        return JacksonParser.parseToJson(model);
    }

    protected <T extends AbstractModel> JsonNode getJsonFromModels(List<T> models) {
        return JacksonParser.parseToJson(models);
    }
}
