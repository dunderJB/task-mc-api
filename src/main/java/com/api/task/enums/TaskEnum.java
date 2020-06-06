package com.api.task.enums;

import net.bytebuddy.implementation.bytecode.Throw;

public enum TaskEnum {
    IN_PROGRESS(1, "In Progress"),
    DONE(2, "Done"),
    CANCELED(3, "Canceled");

    private Integer cod;
    private String msg;


    TaskEnum(int cod, String msg) {
        this.cod = cod;
        this.msg = msg;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static TaskEnum toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(TaskEnum x : TaskEnum.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Stats is not valid: " + cod);
    }
}
