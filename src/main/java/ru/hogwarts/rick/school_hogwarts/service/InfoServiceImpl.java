package ru.hogwarts.rick.school_hogwarts.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
//@Profile("default")
public class InfoServiceImpl implements InfoService {
    @Value("${server.port}")
    private  int port;

    @Override
    public int getPort() {
    return port;
}
}
