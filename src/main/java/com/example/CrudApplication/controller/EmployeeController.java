package com.example.CrudApplication.controller;


import com.example.CrudApplication.model.Login;
import com.example.CrudApplication.model.loginDetails;
import com.example.CrudApplication.repository.EmployeeRepo;
import com.example.CrudApplication.repository.LoginRepo;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;



@RestController
@RequestMapping("/api")
public class EmployeeController {



    @Autowired
    EmployeeRepo repo;






    @Autowired
    LoginRepo repo1;


  /*  @Autowired(required = false)
    LoginService loginService;*/










     /*   @PostMapping("/registration")
    public  String employeeLogin(@RequestBody Login e)
    {

        repo1.save(e);



        return "new Employee Registred Succesfully";
    }




         @GetMapping("/getEmployee")
    public List<Employee> getLogin()
    {
        if (repo1.findAll().equals(repo.findAll()))
          System.out.println("Running...........");
       return repo.findAll();
    }
*/

//steps
    //getobjectbyid
    //compare object.password=login.password
    //

    @PostMapping("/login")
    public String login(@RequestBody Login login) {

        Optional<Login> login1=repo1.findById(login.getId());

        Optional<loginDetails> loginDetails=repo1.findById(login1.get().getUsername());
        if (!loginDetails.get().isLogin())
        {
        if (login1.isPresent()) {
            if (login1.get().getPassword().equals(login.getPassword())) {

               repo1.updateLogindetail(login1.get().getUsername(),true);


                return "login succesfully";
            } else
                return "login unsuccesfull";

            } else{
                return "user not found";
        }
        }
        else {
                return "user already logged in";
            }
        }





         @GetMapping("/logout")
    String logout(@RequestParam ("username") String username)
         {
             repo1.updateLogindetail(username,false);


             return "Loggedout succesfully";
         }
//logout step
        //create one table
        //useremail and islogedin
    //






   /* @PostMapping("/signup")
    public String registerUser(@RequestBody Login signUpDto) {

        // add check for username exists in a DB
        if (repo1.existsById(signUpDto.getId())) {
            return "user is already exist";
        }
        else
        {
            repo1.save(signUpDto);
            repo1.updateLogindetail(signUpDto.get().getUsername());
        return "new user registred succesfully";
    }}*/












   /*  @GetMapping("/getEmployee")
    public List<Employee> getEmployee()
    {
          System.out.println("Running...........");
       return repo.findAll();
    }


    @GetMapping("/Employee/{id}")
    public Optional<Employee> getEmployeeByid(@PathVariable("id") int id)
    {
        return repo.findById(id);
    }

       @PostMapping("/addEmployee")
    public  Employee CreateEmployee(@RequestBody Employee e)
    {

         repo.save(e);
         return e;
    }

   @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id)
{
     Employee employee= repo.getOne(id);
     repo.delete(employee);
     return "Employee Deleted";
}

   @PutMapping("/updateEmployee")
    public Employee SaveOrUpdateEmployee(@RequestBody Employee employee)
   {
       repo.save(employee);
       return employee;
   }
*/

    }

