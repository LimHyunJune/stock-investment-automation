# stock-investment-automation
Investment automation based on Peter Lynch's investment technique  
  
<img src="https://github.com/LimHyunJune/stock-investment-automation/assets/48524793/69e9de8d-c7b6-4cf8-8dd8-bc0b23381349"  width="600" height="400"/>

# Problem  

> Peter Lynch's stock investment method-based collection of investment stocks and repeated operations in selecting selling stocks  
Automation service production considered  
---

# Proposal  

- Target limited to foreign stocks  
- Crawling, Securities Company API  
- Apply flexible structure to API changes and means additions (PSA, MSA)  

---

# Plan  

**Buy**

1. Top xx Companies Picked For 52-Week Report (Crawling)
  1. Crawling target site: https://kr.investing.com/equities/united-states/52-week-high
3. EPS, BPS, PER, PBR index, primary filter by industry (Korea Investment & Securities API)
4. Financial information based secondary filtering (crawling) for remaining companies after primary filtering
1. Crawling target site: https://stockrow.com/
2. Requires Excel download and Excel parsing module
4. Third-order filtering of the remaining companies will be applied by the user himself/herself to the checklist

To do: Add 2.0v selling service after testing the services targeted for purchase

# Architecture

- Apply MSA to ensure stability  
<img src="https://github.com/LimHyunJune/stock-investment-automation/assets/48524793/9435fe5c-db8d-4a13-86c6-d2919d00f340" width="50%" height="50%"/>


- Abstracting for fluid application of different methods of data collection  
  
<img src="https://github.com/LimHyunJune/stock-investment-automation/assets/48524793/f36eacfe-ee5f-48c5-bfe2-fd7c215823a2" width="50%" height="50%"/>

  

- Plug-in Engine Structure for Applying Multiple Buy Checklists

  <img src="https://github.com/LimHyunJune/stock-investment-automation/assets/48524793/944fbb58-6ee2-4bb4-9590-4e7854df5571" width="60%" height="50%"/>



