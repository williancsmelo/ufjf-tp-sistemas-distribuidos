//// src/main/java/ufjf/sd/webservice/service/ClienteService.java
//package ufjf.sd.webservice.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import ufjf.sd.webservice.model.Cliente;
//import ufjf.sd.webservice.repository.ClienteRepository;
//
//
//
//@Service
//public class ClienteService {
//
//    @Autowired
//    private ClienteRepository clienteRepository;
//
//    public List<Cliente> listarClientes() {
//        return clienteRepository.findAll();
//    }
//
//    public Optional<Cliente> encontrarClientePorId(Long id) {
//        return clienteRepository.findById(id);
//    }
//
//    public Cliente salvarCliente(Cliente cliente) {
//        return clienteRepository.save(cliente);
//    }
//
//    public void deletarCliente(Long id) {
//        clienteRepository.deleteById(id);
//    }
//}
