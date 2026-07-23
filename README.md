# CrystamaeHistoria-drake

[![Rama](https://img.shields.io/badge/branch-1.21--latin-2ea44f)](https://github.com/DrakesCraft-Labs/CrystamaeHistoria-drake/tree/1.21-latin)
[![License](https://img.shields.io/github/license/DrakesCraft-Labs/CrystamaeHistoria-drake)](https://github.com/DrakesCraft-Labs/CrystamaeHistoria-drake/blob/1.21-latin/LICENSE)
[![Ultimo commit](https://img.shields.io/github/last-commit/DrakesCraft-Labs/CrystamaeHistoria-drake/1.21-latin)](https://github.com/DrakesCraft-Labs/CrystamaeHistoria-drake/commits/1.21-latin)

CrystamaeHistoria Drake es un addon de progresión temática con historias,
mecánicas mágicas y utilidades complementarias para Slimefun Drake.

## Qué añade a Slimefun
- Extiende la narrativa y variedad de contenido del servidor.
- Incorpora mecánicas mágicas como capa paralela a la rama técnica.
- Aporta objetivos de progreso adicionales para jugadores avanzados.

## Características principales
- Sistema de historias/eventos con contenido temático.
- Ítems y utilidades mágicas integradas a la progresión.
- Compatibilidad de efectos/partículas con Paper 1.21.

## Matriz de compatibilidad
| Componente | Estado |
|---|---|
| Minecraft / Paper / Purpur | **1.21.11** |
| Slimefun Core Drake | **11** (línea `1.21-latin`) |
| Java | 21 |

## Instalación
1. Compila o descarga el JAR correspondiente a la rama `1.21-latin`.
2. Respalda el JAR y `plugins/CrystamaeHistoria/` antes de cambiar versión.
3. Instala un único JAR del addon en una ventana de reinicio.
4. Valida en staging una historia existente, un ítem legacy y efectos de
   partículas antes de anunciar el despliegue.

## Build local
```bash
mvn -B -ntp clean verify
```

Artefacto esperado:
- `target/CrystamaeHistoria-*.jar`

## Flujo de release
1. Crear branch de cambios (`feature/*` o `fix/*`).
2. Abrir PR hacia `1.21-latin` con plan de pruebas.
3. Al mergear, crear tag/release y publicar jar compilado.

Registrar cambios de contenido/lore y validar partículas, materiales e ítems
existentes en runtime. El fork no descarga ni actualiza artefactos en caliente.

## Relación con el monorepo
Este repositorio es la fuente de desarrollo aislado por addon y despliegues
independientes. Conserva IDs, recetas y datos de mundo: una actualización no
debe requerir migrar inventarios de jugadores.
