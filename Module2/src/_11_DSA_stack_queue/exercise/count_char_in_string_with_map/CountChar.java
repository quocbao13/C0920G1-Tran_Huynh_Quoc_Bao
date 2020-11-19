package _11_DSA_stack_queue.exercise.count_char_in_string_with_map;

import java.util.Map;
import java.util.TreeMap;

public class CountChar {
    public static void main(String args[]) {
        String myStr = "ASNDFLHEJKOICHVXCMVKNEKVEDD";
        // khoi tao map
        Map<String, Integer> map = new TreeMap<String, Integer>();

        // them cac phan tu vao map
        map.put("J", 4);
        map.put("C", 1);
        map.put("P", 1);
        map.put("T", 1);
        // show TreeMap
//        Iterator<String> itr = map.keySet().iterator();
//        System.out.println(map.keySet());
//        Set<String> keySet = map.keySet();

//        //chạy vòng lặp để lấy từng kí tự trong chuỗi
//        for (int i = 0; i < myStr.length(); i++) {
//            //tạo check kiểm tra giá trị đã có thì tăng, chưa có thì thêm giá trị mới
//            boolean check = true;
//            //chạy vòng lặp để kiểm tra từng map
//            for (Map.Entry<String, Integer> entry : map.entrySet()) {
//                //Xét điều kiện. Nếu map có giá trị trừng với chuỗi
//                if (entry.getKey().charAt(0) == myStr.charAt(i)) {
//                    //nếu trùng thì tăng số lượng lên thêm 1
//                    entry.setValue(entry.getValue() + 1);
//                    //đánh dấu là đã có giá trị trùng
//                    check = false;
//                }
//            }
//            //nêu chưa có gias trị trùng thì check = true
//            if (check) {
//                //thêm giá trị chưa có vào map
//                map.put(myStr.charAt(i) + "", 1);
//            }
//            //cho check về giá trị ban đầu để chạy vòng sau
//            check = true;
//        }

        for (int i = 0; i < myStr.length(); i++){
            if (map.containsKey(myStr.charAt(i)+"")){
                map.replace(myStr.charAt(i)+"", map.get(myStr.charAt(i)+"")+1);
            }else {
                map.put(myStr.charAt(i)+"", 1);
            }
        }
        System.out.println(map);
    }
}
