const products = [

    {
        productName: "Skoda Wallbox",
        price: 799,
        img: "img/skoda_wallbox.png",

        type: 'osagarria'
    },
    {
        productName: "Karga Kablea (Tipo 2)",
        price: 249,
        img: "img/skoda_cable.png",

        type: 'osagarria'
    },
    {
        productName: "Teilatu Kutxa (400L)",
        price: 450,
        img: "img/skoda_cofre.png",

        type: 'osagarria'
    },
    {
        productName: "Zoru Alfombrillak",
        price: 85,
        img: "img/skoda_alfombrilla.png",

        type: 'osagarria'
    },
    {
        productName: "Bizikleta Euskarria",
        price: 150,
        img: "img/skoda_portabicis.png",

        type: 'osagarria'
    },
    {
        productName: "Haurrentzako Eserlekua",
        price: 350,
        img: "img/skoda_silla_infantil.png",

        type: 'osagarria'
    },
    {
        productName: "Maletero Sarea",
        price: 45,
        img: "img/skoda_red_maletero.png",

        type: 'osagarria'
    },
    {
        productName: "Teilatu Barrak",
        price: 180,
        img: "img/skoda_barras.png",

        type: 'osagarria'
    },
    {
        productName: "Garbiketa Kita",
        price: 35,
        img: "img/skoda_limpieza.png",

        type: 'osagarria'
    }
];

const displayProducts = (productsToShow) => {
    const shopContent = document.getElementById("shopContent");
    shopContent.innerHTML = "";

    productsToShow.forEach(product => {
        const div = document.createElement("div");
        div.className = 'card-products';
        div.style.border = "1px solid #ddd";
        div.style.borderRadius = "8px";
        div.style.padding = "15px";
        div.style.boxShadow = "0 4px 8px rgba(0,0,0,0.1)";
        div.style.backgroundColor = "#fff";
        div.style.textAlign = "center";
        div.style.fontFamily = "'Bungee Spice', sans-serif";
        div.style.color = "#000";


        let buttonHtml = '';
        if (product.type === 'kotxea') {
            buttonHtml = `<button onclick="window.location.href='Konfigurazioa.html'" style="background-color: #4CAF50; color: white; padding: 10px 20px; border: none; cursor: pointer; border-radius: 5px; margin-top: auto;">Konfiguratu</button>`;
        } else {

            buttonHtml = `<button onclick="alert('Produktua saskira gehitu da!')" style="background-color: #333; color: white; padding: 10px 20px; border: none; cursor: pointer; border-radius: 5px; margin-top: auto;">Gehitu Saskira</button>`;
        }

        div.innerHTML = `
        <img src="${product.img}" alt="${product.productName}" style="width: 100%; height: 180px; object-fit: contain; margin-bottom: 10px;">
        <h3>${product.productName}</h3>
        <p class="price">${product.price.toLocaleString()} €</p>
        ${buttonHtml}
      `;
        div.style.display = "flex";
        div.style.flexDirection = "column";
        div.style.alignItems = "center";
        div.style.justifyContent = "space-between";
        div.style.height = "350px";
        shopContent.append(div);
    });
};

displayProducts(products);
