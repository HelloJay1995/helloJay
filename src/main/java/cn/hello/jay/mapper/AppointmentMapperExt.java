package cn.hello.jay.mapper;

import cn.hello.jay.model.po.Appointment;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Resource
public interface AppointmentMapperExt extends AppointmentMapper {

    List<Appointment> listAppointmentByMap(Map<String, Object> param);
}