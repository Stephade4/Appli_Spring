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
  
    // Gestion affichage date/heure programmation
    const radioPlanifie = document.getElementById('planifie');
    const dateHeureDiv = document.getElementById('dateHeureProgrammation');
  
    document.querySelectorAll('input[name="programmation"]').forEach(radio => {
      radio.addEventListener('change', () => {
        if (radioPlanifie.checked) {
          dateHeureDiv.style.display = 'block';
        } else {
          dateHeureDiv.style.display = 'none';
        }
      });
    });
  
    // Form validation
    const form = document.getElementById('notifForm');
    form.addEventListener('submit', (e) => {
      if (!form.checkValidity()) {
        e.preventDefault();
        e.stopPropagation();
        form.classList.add('was-validated');
      }
    });
  });
  