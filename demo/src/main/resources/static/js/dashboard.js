document.addEventListener('DOMContentLoaded', () => {
  const menuToggle = document.getElementById('menuToggle');
  const sidebar = document.getElementById('sidebar');
  const sidebarOverlay = document.getElementById('sidebarOverlay');

  function toggleSidebar() {
    const isActive = sidebar.classList.toggle('active');
    sidebarOverlay.classList.toggle('active', isActive);
    menuToggle.setAttribute('aria-expanded', isActive);
    if (isActive) {
      sidebar.focus();
    }
  }

  menuToggle.addEventListener('click', toggleSidebar);
  sidebarOverlay.addEventListener('click', toggleSidebar);

  // Close sidebar on Escape key
  document.addEventListener('keydown', (e) => {
    if (e.key === "Escape" && sidebar.classList.contains('active')) {
      toggleSidebar();
      menuToggle.focus();
    }
  });

  fetch('/api/trajet/count')
    .then(response => response.json())
    .then(data => {
      document.getElementById("trajet_count").textContent = data.compte;
    })
    .catch(error => {
      console.error("Erreur lors de la recuperation du nombre de trajet :", error);
    });
});
