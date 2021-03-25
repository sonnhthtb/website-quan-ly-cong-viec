package org.sonptit.ToDo.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageUtil {

    public Map<String, String>  getMessage(String message){
        Map<String, String> result = new HashMap<>();
        if(message.equals("update_success")){
            result.put("message", "Cập nhật thành công!");
            result.put("alert", "success");
        }else if(message.equals("insert_success")){
            result.put("message", "Thêm mới thành công!");
            result.put("alert", "success");
        }else if(message.equals("delete_all")){
            result.put("message", "Đã xoá tất cả!");
            result.put("alert", "success");
        }
        else if(message.equals("error_system")){
            result.put("message", "Lỗi!");
            result.put("alert", "danger");
        }
        else if(message.equals("delete")) {
            result.put("message", "Xoá thành công !");
            result.put("alert", "success");
        }
        else if(message.equals("reg_success")){
            result.put("message", "Đăng kí thành công!");
            result.put("alert", "success");
        }
        else if(message.equals("login_fail")){
            result.put("message", "Tài khoản hoặc mật khẩu không chính xác!");
            result.put("alert", "danger");
        }
        else if(message.equals("reg_error")){
            result.put("message", "Tài khoản đã tồn tại!");
            result.put("alert", "danger");
        }

        return result;
    }
}
