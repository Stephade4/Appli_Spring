document.addEventListener('DOMContentLoaded', function() {
  const inscriptionForm = document.getElementById('inscription');

  inscriptionForm.addEventListener('submit', function(event) {
      event.preventDefault();

      const nom = document.getElementById('nom').value;
      const prenom = document.getElementById('prenom').value;
      const cni = document.getElementById('cni').value;
      const telephone = document.getElementById('telephone').value;
      const profession = document.getElementById('profession').value;
      const email = document.getElementById('email').value;
      const motdepasse = document.getElementById('motdepasse').value;
      const conmotdepasse = document.getElementById('conmotdepasse').value;

      // Validation basique côté client
      if (!nom || !prenom || !cni || !telephone || !profession || !email || !motdepasse || !conmotdepasse) {
          alert('Veuillez remplir tous les champs.');
          return;
      }

      if (motdepasse !== conmotdepasse) {
          alert('Les mots de passe ne correspondent pas.');
          return;
      }

      // Envoi des données à l'API RESTful
      fetch("http://localhost:8080/api/clients/inscription", {
          method: 'POST',
          headers: {
              'Content-Type': 'application/json'
          },
          body: JSON.stringify({
              nom: nom,
              prenom: prenom,
              cni: cni,
              telephone: telephone,
              profession: profession,
              email: email,
              motdepasse: motdepasse // Note: En production, hashez le mot de passe côté serveur !
          })
      })
      .then(response => {
          if (!response.ok) {
              return response.json().then(error => {
                  throw new Error(error.message || 'Erreur lors de l\'inscription.');
              });
          }
          return response.json();
      })
      .then(data => {
          alert('Inscription réussie!');
          inscriptionForm.reset(); // Optionnel: réinitialiser le formulaire après succès
          // Rediriger l'utilisateur vers une autre page si nécessaire
          window.location.href = '/connexion.html';
      })
      .catch(error => {
          console.error('Erreur:', error);
          alert('Échec de l\'inscription: ' + error.message);
      });
  });
});