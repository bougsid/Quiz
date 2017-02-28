package com.bougsid;

import com.bougsid.dao.QuizRepository;
import com.bougsid.dao.UserRepository;
import com.bougsid.entities.*;
import com.bougsid.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class QuizApplication implements CommandLineRunner {
    @Autowired
    private QuizRepository repository;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }

    @Override
    public void run(String... strings) throws Exception {
        User user = new User();
        user.setUsername("bougsid");
        user.setPassword("bousgid");
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("user"));
        roles.add(new Role("admin"));
        user.setRoles(roles);
        userRepository.save(user);
        User user2 = new User();
        user2.setUsername("ayoub");
        user2.setPassword("ayoub");
        List<Role> r = new ArrayList<>();
        r.add(new Role("user"));
        user2.setRoles(r);
        userRepository.save(user2);
        List<Quiz> quizzes = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Question> questions = new ArrayList<>();
            Quiz quiz = new Quiz("Quiz" + i, questions, Duration.ofHours(1));
            quizzes.add(quiz);
            for (int j = 0; j < 8; j++) {
                List<Option> options = new ArrayList<>();
                Question question = new Question("Question " + 1, options);
                for (int k = 0; k < 4; k++) {
                    options.add(new Option("Option" + k, (k % 2) == 0, question));
                }
                questions.add(question);
            }
        }
        repository.save(quizzes);
    }
}
