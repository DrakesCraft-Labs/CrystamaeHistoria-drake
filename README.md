# CrystamaeHistoria-drake

[![Rama](https://img.shields.io/badge/branch-1.21--latin-2ea44f)](https://github.com/DrakesCraft-Labs/CrystamaeHistoria-drake/tree/1.21-latin)
[![Licencia](https://img.shields.io/github/license/DrakesCraft-Labs/CrystamaeHistoria-drake)](https://github.com/DrakesCraft-Labs/CrystamaeHistoria-drake/blob/1.21-latin/LICENSE)
[![Ultimo commit](https://img.shields.io/github/last-commit/DrakesCraft-Labs/CrystamaeHistoria-drake/1.21-latin)](https://github.com/DrakesCraft-Labs/CrystamaeHistoria-drake/commits/1.21-latin)

## Descripción técnica
Addon de progresión temática con historias, mecánicas mágicas y utilidades complementarias para Slimefun.

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
| Minecraft | 1.21.x |
| Paper/Purpur | 1.21.x |
| Slimefun Core Drake | 11.x (línea `1.21-latin`) |
| Java | 21 |

## Instalación
1. Descarga el `.jar` de Releases del repositorio.
2. Copia el archivo en la carpeta `plugins/` del servidor.
3. Asegura dependencias (`Slimefun`, `ProtocolLib` u otras según addon).
4. Reinicia el servidor y revisa `logs/latest.log` para validar carga.

## Build local
```bash
mvn -DskipTests clean package
```

Artefacto esperado:
- `target/CrystamaeHistoria-*.jar`

## Flujo de release
1. Crear branch de cambios (`feature/*` o `fix/*`).
2. Abrir PR hacia `1.21-latin` con plan de pruebas.
3. Al mergear, crear tag/release y publicar jar compilado.

Registrar cambios de contenido/lore y validar partículas/materiales en runtime.

## Relación con el monorepo
Este repositorio se mantiene en paralelo con `drakes-slimefun-labs` para desarrollo aislado por addon y despliegues independientes.