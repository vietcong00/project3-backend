package project3.backend.domain.response;

import project3.backend.model.Mistake;

import java.util.List;

public class MistakeListResponse extends BaseResponse{
    List<Mistake> mistakeList ;

    public List<Mistake> getMistakeList() {
        return mistakeList;
    }

    public void setMistakeList(List<Mistake> mistakeList) {
        this.mistakeList = mistakeList;
    }
}
