
const sock = new SockJS('http://localhost:8080/connect');
const client = Stomp.over(sock);

const chat = document.getElementById("comments");

client.connect({}, function (frame) {
    client.subscribe('/chat-receive', response => {
        const html = `<li>${response.body}</li>`;
        chat.innerHTML += html;
    });    
})

const input = document.querySelector("input[type=text]");

document.addEventListener('keyup', ({ key }) => {
    if (key == 'Enter' && input.value) {
        client.send("/app/chat-message", {}, input.value);
        input.value = '';
    }
})

document.querySelector("input + button").addEventListener('click', e => {
    if (input.value) {
        client.send("/app/chat-message", {}, input.value);
        input.value = '';
    }
});

