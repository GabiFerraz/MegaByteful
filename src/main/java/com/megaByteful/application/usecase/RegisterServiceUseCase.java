package com.megaByteful.usecase;

public class RegisterServiceUseCase {
    private final ServiceRepository serviceRepository;

    public RegisterServiceUseCase(ServiceRepository servicoRepository) {
        this.serviceRepository = serviceRepository;
    }

    public Service execute(Service service) {
        return serviceRepository.save(service);
    }
}
