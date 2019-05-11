package io.javabrains.springbootquickstart.courseapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

        @Autowired
        private TopicRepository topicRepository;

        private List<Topic> topics = new ArrayList<>(Arrays.asList(
                new Topic("spring","spring framework","spring framework description"),
                new Topic("java","core java","core java description"),
                new Topic("javascript","javascript","javascript description")
        ));

        public List<Topic> getAllTopics(){
//            return topics;
            List<Topic> topics = new ArrayList<>();
             topicRepository.findAll()
                    .forEach(topics::add);
             return topics;
        }

        public Topic getTopic(String topic){
            return topics.stream().filter(t-> t.getId().equals(topic)).findFirst().get();
        }

        public void addTopic(Topic topic){
            topicRepository.save(topic);
        }

        public void updateTopic(Topic topic, String id){
            Topic result = topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        }
        public void deleteTopic(String id){
            topics.removeIf(t->t.getId().equals(id));
        }
}
