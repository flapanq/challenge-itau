package com.challenge.adapter.outbound.messages;

import java.util.List;

public record ApiSucess (

        String status,

        List<String> messages

) {
}