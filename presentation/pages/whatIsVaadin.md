# Was ist Vaadin
<ul>
    <li v-click>Framework für Java Web Applikationen</li>
    <li v-click>Einfach zu nutzen</li>
    <li v-click>Enthält viele Componenten</li>
    <li v-click>Responsive</li>
    <li v-click>Cross-Plattform</li>
    <li v-click>(Open Source)</li>
    <li v-click>Firmen wie Daimer, Puma oder Lufthansa</li>
</ul>

---

# Preisüberblick

<table>
    <tr v-click>
        <th><strong>Free</strong></th>
        <th><strong>Pro (139€ / Monat)</strong></th>
        <th><strong>Prime</strong></th>
        <th><strong>Ultimate</strong></th>
    </tr>
    <tr v-click>
        <td>Unendliche Projekte</td>
        <td>Kommerzielle Nutzung</td>
        <td>Enterprise Support</td>
        <td>Alle Kits <br> (zB. Swing)</td>
    </tr>
    <tr v-click>
        <td>Gratis UI Componenten</td>
        <td>Komplexere Componenten <br> (Charts, Map, Board)</td>
        <td>Basic Kits</td>
    </tr>
    <tr v-click>
        <td>Ganze Documentation</td>
        <td>UI Test Automation</td>
    </tr>
    <tr v-click >
        <td>Gratis UI Componenten</td>
        <td>Drag & Drop UI Designer</td>
    </tr>
</table>

---

# Aufbau

<style>
.vaadinContainer {
    display: grid;
    grid-template-areas:
        'flow uic kits'
        'design designer test' 
}

.vaadinComponent {
    border: 2px solid grey;
    border-radius: 10px;
    margin: 1vh 2vw;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    flex-wrap: no-wrap;
    padding: 1vw 2vw;
    width: 10vw;
    height: 15vh;
    text-align: center;
}

.vaadinComponent:nth-child(1) {
    grid-area: flow;
}

.vaadinComponent:nth-child(2) {
    grid-area: uic;
}

.vaadinComponent:nth-child(3) {
    grid-area: kits;
}

.vaadinComponent:nth-child(4) {
    grid-area: design;
}

.vaadinComponent:nth-child(5) {
    grid-area: designer;
}
.vaadinComponent:nth-child(6) {
    grid-area: test;
}

</style>

<div class="vaadinContainer">
    <div class="vaadinComponent">
        <svg width="35" height="35" viewBox="0 0 64 64" fill="none" xmlns="http://www.w3.org/2000/svg"> <path d="M57.457 33.528c-10.165 7.746-27.28 1.96-33.372-6.031-9.2-12.048-26.666 2.296-15.446 14.39 14.512 15.139 40.352 9.98 48.818-8.359z" fill="#00B4F0"></path><path d="M8.628 41.902c14.527 15.124 40.382 9.965 48.832-8.359 8.343-18.538-19.686-28.182-25.09-9.291a23.82 23.82 0 01-3.612 7.592c-4.47 6.23-11.818 10.058-20.13 10.058z" fill="#FF707A"></path><path d="M57.46 33.528c-8.174 6.246-20.88 3.705-28.702-1.699-4.47 6.246-11.818 10.073-20.13 10.057 5.893 6.139 13.67 8.94 21.385 8.864 11.267-.092 22.426-6.322 27.447-17.222z" fill="#5748FF"></path></svg>
        Flow Framework
    </div>
    <div class="vaadinComponent">
        <svg width="28" height="28" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg"> <path d="M20.025 26.84c4.405 0 7.975-3.558 7.975-7.946s-3.57-7.946-7.975-7.946c-4.404 0-7.975 3.557-7.975 7.946 0 4.388 3.57 7.946 7.975 7.946Z" fill="#FF707A"></path><path d="m10.265 6.419-6.018 10.39a1.829 1.829 0 0 0 .67 2.504c.28.16.596.246.918.247h12.043a1.845 1.845 0 0 0 1.595-.916 1.829 1.829 0 0 0 0-1.834L13.455 6.419A1.837 1.837 0 0 0 11.86 5.5a1.846 1.846 0 0 0-1.595.919Z" fill="#00B4F0"></path><path d="m19.473 16.81-2.926-5.055a7.966 7.966 0 0 0-3.277 2.926 7.925 7.925 0 0 0-1.22 4.213c0 .226 0 .446.037.666h5.79a1.846 1.846 0 0 0 1.596-.916 1.829 1.829 0 0 0 0-1.834Z" fill="#5748FF"></path></svg>
        UI Componenten
    </div>
    <div class="vaadinComponent">
        <svg width="28" height="28" viewBox="0 0 64 54" fill="none" xmlns="http://www.w3.org/2000/svg"> <g clip-path="url(#clip0_1_2897)"><path d="M61.5766 22.8442L33.4638 0.515814C32.0999 -0.171261 30.4685 -0.0968051 29.1687 0.69182C27.8623 1.47705 27.0737 2.87829 27.0737 4.38107V49.0515C27.0737 50.5508 27.8623 51.9487 29.1687 52.7373C29.8728 53.1638 30.6715 53.3804 31.4805 53.3804C32.1608 53.3804 32.8378 53.2247 33.4638 52.9133L61.5766 30.5781C62.9305 29.3055 64 28.351 64 26.7095C64 25.0679 63.093 24.1845 61.5766 22.8442Z" fill="#FF707A"></path><path d="M34.4996 22.8459L6.3868 0.517462C5.02279 -0.169613 3.39478 -0.0951571 2.09509 0.693468C0.788619 1.4787 0 2.87994 0 4.38272V49.0531C0 50.5525 0.788619 51.9504 2.09509 52.7389C2.79909 53.1654 3.59787 53.382 4.40679 53.382C5.0871 53.382 5.76403 53.2263 6.39019 52.915L34.5029 30.5798C35.8568 29.3071 36.9263 28.3526 36.9263 26.7112C36.9263 25.0696 36.0159 24.1862 34.4996 22.8459Z" fill="#00B4F0"></path><path d="M34.4996 22.8454L27.0737 16.9937C27.0737 18.2568 27.0737 25.6651 27.0737 27.1679V32.2437C27.0737 33.743 27.0737 35.6901 27.0737 36.612L34.5029 30.5793C35.8568 29.3066 36.9263 28.3521 36.9263 26.7107C36.9263 25.0691 36.0159 24.1857 34.4996 22.8454Z" fill="#5748FF"></path></g> <defs><clipPath id="clip0_1_2897"><rect width="64" height="53.4291" fill="white"></rect></clipPath></defs></svg>
        Kits
    </div>
    <div class="vaadinComponent">
        <svg width="28" height="28" viewBox="0 0 64 64" fill="none" xmlns="http://www.w3.org/2000/svg"> <path d="M46.158 10H28.099a4.434 4.434 0 00-4.434 4.434v24.467a4.434 4.434 0 004.434 4.434h18.059a4.434 4.434 0 004.434-4.434V14.434A4.434 4.434 0 0046.158 10z" fill="#FF707A"></path><path d="M35.493 20.665H17.434A4.434 4.434 0 0013 25.099v24.467A4.434 4.434 0 0017.434 54h18.06a4.434 4.434 0 004.434-4.434V25.099a4.434 4.434 0 00-4.435-4.434z" fill="#00B4F0"></path><path d="M35.504 20.665h-11.84V38.89a4.434 4.434 0 004.435 4.434h11.84V25.1a4.435 4.435 0 00-4.435-4.434z" fill="#5748FF"></path></svg>
        Design System Publisher
    </div>
    <div class="vaadinComponent">
        <svg width="28" height="28" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg"> <path d="M19.5 8H7a2.5 2.5 0 0 0-2.5 2.5A2.5 2.5 0 0 0 7 13h12.5v12.5A2.5 2.5 0 0 0 22 28a2.5 2.5 0 0 0 2.5-2.5V11a3 3 0 0 0-3-3h-2Z" fill="#FF707A"></path><path d="M13 24.5h12.5A2.5 2.5 0 0 0 28 22a2.5 2.5 0 0 0-2.5-2.5H13V7a2.5 2.5 0 0 0-2.5-2.5A2.5 2.5 0 0 0 8 7v14.5a3 3 0 0 0 3 3h2Z" fill="#00B4F0"></path><path fill="#5748FF" d="M8 8h4.998v4.998H8zM19.5 19.5h4.998v4.998H19.5z"></path></svg>
        Designer
    </div>
    <div class="vaadinComponent">
        <svg width="28" height="28" viewBox="0 0 32 32" fill="none" xmlns="http://www.w3.org/2000/svg"> <path d="M26.306 13.955a3.75 3.75 0 0 0-5.303-5.303l-9.546 9.546A3.75 3.75 0 0 0 16.76 23.5l9.546-9.546Z" fill="#00B4F0"></path><path d="M11.455 12.894a3.75 3.75 0 1 0-5.303 5.303l5.303 5.303a3.75 3.75 0 1 0 5.303-5.303l-5.303-5.303Z" fill="#FF707A"></path><path d="m8.803 20.85 5.303-5.303 5.304 5.303-2.652 2.652a3.75 3.75 0 0 1-5.303 0l-2.652-2.651Z" fill="#5748FF"></path></svg>
        TestBench
    </div>
</div>