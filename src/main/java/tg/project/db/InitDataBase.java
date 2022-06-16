//package tg.project.db;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import tg.project.db.models.Serial;
//import tg.project.db.models.User;
//import tg.project.db.repositories.SerialRepository;
//import tg.project.db.repositories.UserRepository;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//@Component
//public class InitDataBase {
//
//    @Autowired
//    private void init(SerialRepository serialRepository, UserRepository userRepository) {
//        Set<Serial> serials_ = new HashSet<>();
//        serials_.add(new Serial("404942"));
//        serials_.add(new Serial("820385"));
//        serials_.add(new Serial("404900"));
//        serials_.add(new Serial("195384"));
//
//        List<Serial> serials = serialRepository.saveAll(serials_);
//
//        Set<User> users_ = new HashSet<>();
//        users_.add(new User("1"));
//        users_.add(new User("2"));
//        users_.add(new User("3"));
//        users_.add(new User("4"));
//
//        List<User> users = userRepository.saveAll(users_);
//
//        User user1 = users.get(0);
//        Set<Serial> serials1 = new HashSet<>();
//        serials1.add(serials.get(0));
//        serials1.add(serials.get(1));
//        serials1.add(serials.get(2));
//        serials1.add(serials.get(3));
//        user1.setSerials(serials1);
//
//        User user2 = users.get(1);
//        Set<Serial> serials2 = new HashSet<>();
//        serials2.add(serials.get(0));
//        serials2.add(serials.get(1));
//        serials2.add(serials.get(2));
//        user2.setSerials(serials2);
//
//        User user3 = users.get(2);
//        Set<Serial> serials3 = new HashSet<>();
//        serials3.add(serials.get(2));
//        serials3.add(serials.get(1));
//        serials3.add(serials.get(3));
//        user3.setSerials(serials3);
//
//        userRepository.saveAll(users);
//
//        Set<Long> uniqueSubscribedSerials = serialRepository.getUniqueSubscribedSerials();
//        System.out.println("UniqueSubscribedSerials: " + uniqueSubscribedSerials);
//        Set<Long> allUsersWhoSubscribeSerialByApiId = userRepository.getAllUsersWhoSubscribeSerialByApiId(178707L);
//        System.out.println("AllUsersWhoSubscribeSerialByApiId: " + allUsersWhoSubscribeSerialByApiId);
//    }
//}
