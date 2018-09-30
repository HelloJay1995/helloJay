package cn.hello.jay.service;

import cn.hello.jay.mapper.AppointmentMapperExt;
import cn.hello.jay.model.po.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentMapperExt appointmentMapper;

    public List<Appointment> test(String jszh) {
        Map<String, Object> params = new HashMap<>();
        params.put("isDeleted", 0);
        params.put("jszh", jszh);
        return appointmentMapper.listAppointmentByMap(params);
    }

    public void insert(Appointment appointment) {
        appointment.setCreateTime(new Date());
        appointment.setUpdateTime(new Date());
        appointmentMapper.insertSelective(appointment);
    }
}
