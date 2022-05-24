addEventListener("load", function () {
  setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
  window.scrollTo(0, 1);
}

function handleSubmit(event) {
  event.preventDefault();
  const data = new FormData(event.target);
  const value = Object.fromEntries(data.entries());

  try {
    fetch("/api/v1/account/signup", {
      method: 'POST',
      body: JSON.stringify(value),
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(() => window.location.href = '/passport-attachment');
  } catch (error) {
    console.error('Ошибка:', error);
  }
}

const form = document.querySelector("#signupForm");
form.addEventListener('submit', handleSubmit);