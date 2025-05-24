document.addEventListener('DOMContentLoaded', () => {
    const menuToggle = document.getElementById('menuToggle');
    const sidebar = document.getElementById('sidebar');
    const sidebarOverlay = document.getElementById('sidebarOverlay');
  
    function toggleSidebar() {
      const isActive = sidebar.classList.toggle('active');
      sidebarOverlay.classList.toggle('active', isActive);
      menuToggle.setAttribute('aria-expanded', isActive);
      if (isActive) sidebar.focus();
    }
  
    menuToggle.addEventListener('click', toggleSidebar);
    sidebarOverlay.addEventListener('click', toggleSidebar);
  
    document.addEventListener('keydown', (e) => {
      if (e.key === "Escape" && sidebar.classList.contains('active')) {
        toggleSidebar();
        menuToggle.focus();
      }
    });

    document.getElementById('ajt_trajet').addEventListener('submit',
        function(event){
            event.preventDefault();

            const ville_depart= document.getElementById('ville_depart').value;
            const ville_arrive= document.getElementById('ville_arrive').value;
            const distance= document.getElementById('distance').value;
            const tarif= document.getElementById('tarif').value;
            const statut= document.getElementById('statut').value;
            const id_class= document.getElementById('id_class').value;

            fetch(`/api/trajet/add?ville_depart=${encodeURIComponent(ville_depart)}&ville_arrive=${encodeURIComponent(ville_arrive)}&`+
                                    `distance=${encodeURIComponent(distance)}&tarif=${encodeURIComponent(tarif)}&`+
                                    `statut=${encodeURIComponent(statut)}&id_class=${encodeURIComponent(id_class)}`,{method:'POST'})
            .then(response=> response.text())
            .then(data => alert(data))
            .catch(error => console.error('Erreur :', error));
        }
    );

    document.getElementById('ajout_class').addEventListener('submit',
        function(event){
            event.preventDefault();

            const libelle = document.getElementById('nom').value;

            fetch(`/api/classtrajet/add?libelle=${encodeURIComponent(libelle)}`, {method:'POST'})
            .then(response=> response.text())
            .then(data => alert(data))
            .catch(error => console.error('Erreur :', error));
        }
    );

    fetch('/api/classtrajet/all')
      .then(response => response.json())
      .then(data => {
        const tableBody = document.querySelector('#classTable tbody');
        
        data.forEach(classtrajet => {
          const row= document.createElement('tr');
          const libelle= document.createElement('td');
          libelle.textContent= classtrajet.libelle;
          row.appendChild(libelle);

          tableBody.appendChild(row);
        });
      })
      .catch(error => console.error('Erreur: ', error));


    fetch('/api/classtrajet/all')
      .then(response => response.json())
      .then(data => {
        const select = document.getElementById('id_class');
        
        data.forEach(classtrajet => {
          const option= document.createElement('option');
          option.value= classtrajet.idclass;
          option.textContent= classtrajet.libelle;

          select.appendChild(option);
        });
      })
      .catch(error => console.error('Erreur: ', error));

    fetch('/api/trajet/all')
      .then(response => response.json())
      .then(data => {
        const tableBody = document.querySelector('#trajetTable tbody');
        
        data.forEach(trajetoire => {
          const row= document.createElement('tr');
          
          const vildepart= document.createElement('td');
          vildepart.textContent= trajetoire.vildepart;
          row.appendChild(vildepart);

          const vilarrive= document.createElement('td');
          vilarrive.textContent= trajetoire.vilarrive;
          row.appendChild(vilarrive);

          const distance = document.createElement('td');
          distance.textContent= trajetoire.distance;
          row.appendChild(distance);

          const tarif= document.createElement('td');
          depart.textContent= trajetoire.tarif;
          row.appendChild(tarif);

          const statut= document.createElement('td');
          statut.textContent= trajetoire.statut;
          row.appendChild(statut);

          const clas= document.createElement('td');
          clas.textContent= trajetoire.classtrajet;
          row.appendChild(clas);

          tableBody.appendChild(row);
        });
      })
      .catch(error => console.error('Erreur: ', error));
})