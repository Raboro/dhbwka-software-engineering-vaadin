# Inhalt
- Was ist Vaadin 
- Funktionen
- Vor- und Nachteile
- Projektaufbau
- Code Beispiele 

<div class="w-60 relative mt-4">
  <div class="relative w-80 h-40">
    <img
      v-motion
      :initial="{ x: 800, y: -100, scale: 1.5, rotate: -50 }"
      :enter="final"
      class="absolute top-0 left-0 right-0 bottom-0"
      src="assets/icon.png"
      alt=""
    />
  </div>
</div>

<script setup lang="ts">
const final = {
  x: 500,
  y: -150,
  rotate: 0,
  scale: 1,
  transition: {
    type: 'spring',
    damping: 10,
    stiffness: 20,
    mass: 2
  }
}
</script>