package hospital.controller;

import hospital.models.Appointment;
import hospital.models.Department;
import hospital.models.Patient;
import hospital.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/{doctorId}")
    public String getAllDepartments(Model model, @PathVariable("doctorId") Long id){
        model.addAttribute("doctorId", id);
        model.addAttribute("appointments", appointmentService.getAllAppointments(id));
        return "appointmentMainPage";
    }

    @DeleteMapping({"/{doctorId}/deleteAppointment/{appointmentId}"})
    public String deleteHospital(@PathVariable("appointmentId")Long id, @PathVariable("doctorId") Long doctorId){
        appointmentService.deleteAppointments(id);
        return "redirect:/appointments/"+doctorId;
    }
    @GetMapping("/new/{doctorId}")
    public String newDepartment(Model model, @PathVariable("doctorId") Long id){
        model.addAttribute("newAppointment", new Appointment());
        model.addAttribute("newPatient", new Patient());
        model.addAttribute("doctorId", id);
        return "newAppointment";
    }

    @PostMapping("/save/{doctorId}")
    public String saveHospital(@ModelAttribute("newPatient") Patient patient, @PathVariable("doctorId") Long id, @ModelAttribute("newAppointment") Appointment appointment){
        appointmentService.saveAppointment(patient, appointment, id);
        return "redirect:/appointments/"+ id;
    }
}
