---
theme: seriph
background: https://unsplash.com/photos
class: text-center
highlighter: shiki
lineNumbers: false
info: |
  ## Slidev Starter Template
  Presentation slides for developers.

  Learn more at [Sli.dev](https://sli.dev)
drawings:
  persist: false
transition: slide-left
title: Vaadin
mdc: true
---

# Vaadin

<div class="w-60 relative mt-4">
  <div class="relative w-40 h-40">
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

<div class="pt-12">
  <span @click="$slidev.nav.next" class="px-2 py-1 rounded cursor-pointer" hover="bg-white bg-opacity-10">
    Java Web App Development Framework
  </span>
</div>

<script setup lang="ts">
const final = {
  x: 360,
  y: 0,
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
---
src: pages/content.md
---

---
src: pages/whatIsVaadin.md
---

---
src: pages/src.md
---