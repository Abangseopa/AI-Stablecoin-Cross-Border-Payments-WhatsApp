# AI Stablecoin Cross-Border Payments (Delivered via WhatsApp)

This platform lets users send international money transfers through WhatsApp, powered by stablecoin rails. Users initiate payouts conversationally in WhatsApp and the backend orchestrates KYC, customer creation, checkout, and settlement through Supabase Edge Functions + Bridge API + Stripe. This was done by integrating with bridge.xyz api. 

### Live Flow
The sender chats → enters payout → WhatsApp bot calls Supabase → bridge API moves funds → stablecoin settles instantly → recipient withdraws locally.
### Screenshots

#### Recipient Flow (WhatsApp)
| Step | Screenshot |
|---|---|
| Receive payment link + onboarding | ![page1](screenshots/page1.png) |
| Enter payout details | ![page2](screenshots/page2.png) |
| Confirm details | ![page3](screenshots/page3.png) |
| Recipient ready → funds incoming | ![page4](screenshots/page4.png) |

#### Sender Flow (WhatsApp)
| Step | Screenshot |
|---|---|
| Enter payout amount conversationally | ![page5](screenshots/page5.png) |
| Confirm + authorize | ![page6](screenshots/page6.png) |
| Settlement triggered instantly | ![page7](screenshots/page7.png) |


### Architecture
| Folder | Purpose |
|--------|----------|
| `/backend/supabase` | Supabase Edge Functions handling transfers, webhooks, KYC, checkout |
| `/ui` | WhatsApp webhook handler + bot logic |
| `/backend/config.toml` + `demo.json` | Local testing config + sample payloads |

### Why this mattered
Traditional cross-border flows are slow and expensive. Stablecoins + messaging made it instant, lightweight and UX-native. 
