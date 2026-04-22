# RagBenchmark - Clean Architecture Android Project

A multi-module Android project following Clean Architecture principles, simple as possible, with the only purpose to measure the efficiency of RAG AI structures.
I will upload here all the results, from each technique adopted, and hope that could be useful data to help make decisions throught its analysis

## Problem description

As we are evolving from simple prompts to a scalable multi-agents usage, self sustained, a problem that came across is the usage of the tokens, same issue as the obvious case on Amazon AWS "just a quick test" and then a bill bigger than ourselves lol.
The purpose here is to find out which approach is more efficient, at the same time, need to keep high accuracy (of course depends on the model used) to use less tokens, and try to keep a memory storage, smaller in data, but huge in knowledge to help Claude make the decisions and develop the code, following the same structure as defined on the project, like guardrails, rules, embeddings, etc.

### Mapped Techniques

1. ✅ **Zero Technique** — Using anthropic Claude
2. ✅ **Obsidian + Graphify** — Using internal usage of obsidian combined with graphify
3. ✅ **Graphify Self Developed** — Using a self developed graphify, to create inner graphs and external files to help Claude decide which one will use

### Respective Results

Here is a following result structured, using the same API Key from Anthropic, measure in tokens usage

1. ✅ **Zero Technique** — $ 0.00
2. ✅ **Obsidian + Graphify** — $ 0.00
3. ✅ **Graphify Self Developed** — $ 0.00
