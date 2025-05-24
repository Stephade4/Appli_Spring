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
  
    // Form validations for security and preferences forms
    const securityForm = document.getElementById('securityForm');
    if (securityForm) {
      securityForm.addEventListener('submit', (e) => {
        if (!securityForm.checkValidity()) {
          e.preventDefault();
          e.stopPropagation();
          securityForm.classList.add('was-validated');
        }
      });
    }
  
    const preferencesForm = document.getElementById('preferencesForm');
    if (preferencesForm) {
      preferencesForm.addEventListener('submit', (e) => {
        if (!preferencesForm.checkValidity()) {
          e.preventDefault();
          e.stopPropagation();
          preferencesForm.classList.add('was-validated');
        }
      });
    }
  });
  