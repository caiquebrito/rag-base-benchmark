

<!-- rag-section -->
## RAG — Contexto obrigatório

**REGRA ABSOLUTA: ao iniciar qualquer sessão neste projeto, ANTES de responder qualquer coisa, você DEVE:**

1. Ler os arquivos abaixo na ordem listada
2. Imprimir um bloco de contexto no seguinte formato exato:

```
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  RAG carregado: rag-base-benchmark
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Stack:      <stack detectada no RESUMO.md>
  Arquivos:   <N> arquivos · <N> funções · <N> classes
  Último sync: <data do último sync em activity.md>
  Memória:    <1-2 frases resumindo o propósito do projeto>
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
```

Só então responda o que o usuário pediu.

### Arquivos para ler (nesta ordem)

**1. Memória do projeto:**
```
C:\Users\caique.brito\Dev\Rag\rag-base-benchmark\memory/RESUMO.md
```
Se existirem outros `.md` em `C:\Users\caique.brito\Dev\Rag\rag-base-benchmark\memory/`, leia-os também.

**2. Log de atividade recente** (últimas 30 linhas):
```
C:\Users\caique.brito\Dev\Rag\rag-base-benchmark\logs\activity.md
```

**3. Grafo do código** (leia apenas `stats` e os primeiros 30 nós para entender a estrutura):
```
C:\Users\caique.brito\Dev\Rag\rag-base-benchmark\graph\graph.json
```

### Comandos úteis

Atualizar grafo e memória:
```bash
python3 C:\Users\caique.brito\Dev\Rag\scripts\sync.py C:\Users\caique.brito\Documents\Repositories\rag-base-benchmark
```

Visualizador 3D:
```bash
python3 C:\Users\caique.brito\Dev\Rag/rag --serve
```
<!-- end-rag-section -->
