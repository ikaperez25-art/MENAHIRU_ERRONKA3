const canvas = document.getElementById('munduaCanvas');
const ctx = canvas.getContext('2d');

let width, height;
let globeScale;

function resize() {
    width = canvas.parentElement.clientWidth;
    height = 300; // Fixed height
    canvas.width = width;
    canvas.height = height;
    globeScale = Math.min(width, height) * 0.4;
}

window.addEventListener('resize', resize);
resize();

let angle = 0;

function drawGlobe() {
    ctx.clearRect(0, 0, width, height);

    const centerX = width / 2;
    const centerY = height / 2;

    ctx.strokeStyle = '#4CAF50'; // Green color for "eco" vibe
    ctx.lineWidth = 1.5;

    // Draw sphere outline
    ctx.beginPath();
    ctx.arc(centerX, centerY, globeScale, 0, Math.PI * 2);
    ctx.stroke();

    // Draw longitude lines (rotating)
    const numLongitudes = 12;
    for (let i = 0; i < numLongitudes; i++) {
        let theta = (i * Math.PI * 2) / numLongitudes + angle;
        // Map 3D longitude to 2D ellipse width
        let x = Math.sin(theta) * globeScale;

        // Only draw front-facing lines (or draw back ones lighter)
        // Simple 3D effect: ellipse width varies with rotation
        ctx.beginPath();
        ctx.ellipse(centerX, centerY, Math.abs(x), globeScale, 0, 0, Math.PI * 2);

        // Add transparency for depth effect
        if (Math.cos(theta) > 0) {
            ctx.globalAlpha = 1;
        } else {
            ctx.globalAlpha = 0.2;
        }
        ctx.stroke();
    }

    ctx.globalAlpha = 1;

    // Draw latitude lines (static or slightly tilted)
    const numLatitudes = 8;
    for (let i = 1; i < numLatitudes; i++) {
        let y = -globeScale + (i * globeScale * 2) / numLatitudes;
        // Width at this latitude
        let latitudeRadius = Math.sqrt(globeScale * globeScale - y * y);

        ctx.lineWidth = 1;
        ctx.beginPath();
        // Draw straight lines for latitudes in a simple orthographic projection style
        // Or narrow ellipses. Let's stick to straight lines for a "wireframe tech" look
        // or actually, ellipses are better for a globe
        ctx.ellipse(centerX, centerY + y * 0.3, latitudeRadius, latitudeRadius * 0.2, 0, 0, Math.PI * 2);
        // Note: Simple fake perspective for latitudes
        ctx.stroke();
    }

    angle += 0.005;
    requestAnimationFrame(drawGlobe);
}

drawGlobe();
