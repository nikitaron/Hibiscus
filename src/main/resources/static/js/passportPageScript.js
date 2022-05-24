addEventListener("load", function () {
  setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
  window.scrollTo(0, 1);
}

function handleConfirm(event) {
  event.preventDefault();
  var passport = {};
  passport.identityCode = document.querySelector('input[name="identityCode"]').value;
  passport.dob = document.querySelector('input[name="dateOfBirth"]').value + 'T00:00';

  var sns = {};
  sns.name = document.querySelector('input[name="name"]').value;
  sns.surname = document.querySelector('input[name="surname"]').value;
  sns.succession = document.querySelector('input[name="succession"]').value;

  passport.sns = sns;

  console.log(JSON.stringify(passport));

  try {
    fetch("/api/v1/account/passport", {
      method: 'POST',
      body: JSON.stringify(passport),
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(() => window.location.href = '/main-page');
  } catch (error) {
    console.error('Ошибка:', error);
  }
}

const form = document.querySelector("#passportForm");
form.addEventListener('submit', handleConfirm);
