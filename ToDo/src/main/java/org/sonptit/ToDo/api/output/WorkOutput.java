package org.sonptit.ToDo.api.output;

import org.sonptit.ToDo.dto.WorkDTO;

import java.util.ArrayList;
import java.util.List;

public class WorkOutput {
    private List<WorkDTO> listResult = new ArrayList<>();

    public List<WorkDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<WorkDTO> listResult) {
        this.listResult = listResult;
    }
}
