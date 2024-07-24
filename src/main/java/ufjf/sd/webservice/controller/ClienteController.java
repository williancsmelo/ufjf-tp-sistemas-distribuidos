package ufjf.sd.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import ufjf.sd.webservice.model.Cliente;
import ufjf.sd.webservice.repository.ClienteRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/clients")
public class ClienteController {

    @Autowired
    private ClienteRepository clientRepository;

    @GetMapping
    public List<Cliente> getAllUsers() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente getUserById(@PathVariable Long id) {
        return clientRepository.findById(id).get();
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Cliente> createClient(@RequestBody Cliente cliente) {
        Cliente savedClient = clientRepository.save(cliente);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Cliente updateUser(@PathVariable Long id, @RequestBody Cliente user) {
        Cliente existingUser = clientRepository.findById(id).get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return clientRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        try {
            clientRepository.findById(id).get();
            clientRepository.deleteById(id);
            return "User deleted successfully";
        } catch (Exception e) {
            return "User not found";
        }
    }

}

//// src/main/java/ufjf/sd/webservice/controller/ClienteController.java
// package ufjf.sd.webservice.controller;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import ufjf.sd.webservice.model.Cliente;
// import ufjf.sd.webservice.service.ClienteService;
//
// import java.util.List;
// import java.util.Optional;
//
// @RestController
// @RequestMapping("/api/clientes")
// public class ClienteController {
//
// @Autowired
// private ClienteService clienteService;
//
// @GetMapping
// public List<Cliente> listarClientes() {
// return clienteService.listarClientes();
// }
//
// @GetMapping("/{id}")
// public ResponseEntity<Cliente> encontrarClientePorId(@PathVariable Long id) {
// Optional<Cliente> cliente = clienteService.encontrarClientePorId(id);
// return cliente.map(ResponseEntity::ok).orElseGet(() ->
//// ResponseEntity.notFound().build());
// }
//
// @PostMapping
// public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
// Cliente clienteSalvo = clienteService.salvarCliente(cliente);
// return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
// }
//
// @DeleteMapping("/{id}")
// public ResponseEntity<java.lang.Object> deletarCliente(@PathVariable Long id)
//// {
// clienteService.deletarCliente(id);
// return ResponseEntity.noContent().build();
// }
// }
