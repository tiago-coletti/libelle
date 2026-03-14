setInterval(() => {
    fetch("/api/verificacao_email")
        .then(res => res.json())
        .then(data => {
            if (data.verificado) {
                window.location.href = "/email-confirmado";
            }
        });
}, 5000);