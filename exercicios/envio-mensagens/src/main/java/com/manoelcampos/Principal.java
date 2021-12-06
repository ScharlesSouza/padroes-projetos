package com.manoelcampos;

import com.manoelcampos.people.Customer;
import com.manoelcampos.mensagens.Newsletter;

import java.util.List;

public class Principal {
    public static void main(String[] args) {
        final List<Customer> customers = List.of(
            new Customer("Manoel", "(63) 1111-2222", "manoel@teste.com"),
            new Customer("Breno",  "(63) 3333-4444", "breno@teste.com"),
            new Customer("Raysa",  "(63) 5555-6666", "raysa@teste.com")
        );

        final Newsletter newsletter = new Newsletter(customers);
        String msgTemplate = "Aproveite as promoções de natal #name.";
        newsletter.send(msgTemplate);
    }
}
