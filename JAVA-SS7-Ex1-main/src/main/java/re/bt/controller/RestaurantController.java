package re.bt.controller;
// - Spring Data Binding map giá trị từ form HTML vào object dựa trên
//   tên field + getter/setter trùng với thuộc tính name trong thẻ input.
//
// - Lỗi tên quán bị null:
//   Form dùng name="restaurantName" nhưng model chỉ có field "name"
//   (với setter là setName). Spring tìm setRestaurantName(...) không thấy
//   nên không bind được, kết quả profile.name = null.
//
// - Lỗi checkbox active:
//   + value="MỞ_CỬA" không phải giá trị Spring có thể convert sang boolean
//     (chỉ hiểu "true", "false", "on").
//   + Khi checkbox không được tick thì trình duyệt không gửi tham số nào,
//     nên backend dễ nhận sai hoặc thiếu giá trị cho field active.
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import re.bt.model.RestaurantProfile;

@Controller
public class RestaurantController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("restaurantProfile", new RestaurantProfile());
        return "restaurant";
    }
    @PostMapping("/update-profile")
    public String updateProfile(RestaurantProfile profile) {
        System.out.println("Tên quán: " + profile.getName());
        System.out.println("SĐT: " + profile.getPhone());
        System.out.println("Trạng thái: " + profile.isActive());



        return "success";
    }
}
