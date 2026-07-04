import { Link } from 'react-router-dom';
import Navbar from '../components/Navbar';

const LandingPage = () => {
  return (
    <div className="min-h-screen bg-bglight flex flex-col justify-between">
      <Navbar />

      <main className="flex-grow">
        {/* Hero Section */}
        <section className="relative overflow-hidden bg-primary py-24 sm:py-32 text-white">
          {/* Accent decoration */}
          <div className="absolute top-0 right-0 w-96 h-96 bg-accent/20 rounded-full blur-3xl transform translate-x-1/2 -translate-y-1/2"></div>
          <div className="absolute bottom-0 left-0 w-96 h-96 bg-accent/10 rounded-full blur-3xl transform -translate-x-1/2 translate-y-1/2"></div>

          <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 relative z-10 text-center">
            <h1 className="text-4xl sm:text-6xl font-black tracking-tight text-white mb-6 leading-tight">
              ELEVATE: <span className="text-accent">TechFests@Campus</span>
            </h1>
            <p className="text-xl sm:text-2xl font-medium text-gray-200 max-w-3xl mx-auto mb-10">
              Connecting India's Startup Ecosystem with Campus Knowledge Events
            </p>
            
            <div className="flex flex-col sm:flex-row justify-center items-center gap-4">
              <Link
                to="/register?role=CAMPUS"
                className="w-full sm:w-auto px-8 py-4 bg-accent hover:bg-accent-dark text-white rounded-xl text-lg font-bold shadow-lg hover:shadow-xl transition transform hover:-translate-y-0.5 duration-200 text-center"
              >
                I'm a Campus
              </Link>
              <Link
                to="/register?role=CORPORATE"
                className="w-full sm:w-auto px-8 py-4 bg-white hover:bg-gray-100 text-primary rounded-xl text-lg font-bold shadow-lg hover:shadow-xl transition transform hover:-translate-y-0.5 duration-200 text-center"
              >
                I'm a Corporate
              </Link>
            </div>
          </div>
        </section>

        {/* Feature section */}
        <section className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-20">
          <div className="text-center mb-16">
            <h2 className="text-3xl font-black text-primary mb-4">How ELEVATE Works</h2>
            <p className="text-lg text-gray-600 max-w-xl mx-auto">
              Empowering campuses and businesses to collaborate through educational events.
            </p>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
            {/* Feature 1 */}
            <div className="bg-white p-8 rounded-2xl shadow-md border border-gray-100 hover:shadow-xl transition duration-300">
              <div className="w-12 h-12 bg-primary/10 text-primary rounded-xl flex items-center justify-center mb-6">
                <svg className="w-6 h-6 text-primary" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                  <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2m-3 7h3m-3 4h3m-6-4h.01M9 16h.01"></path>
                </svg>
              </div>
              <h3 className="text-xl font-bold text-primary mb-3">Discover Events</h3>
              <p className="text-gray-600 leading-relaxed text-sm">
                Campuses list their hackathons, ideathons, workshops and seminars on the ELEVATE pool for corporates to discover.
              </p>
            </div>

            {/* Feature 2 */}
            <div className="bg-white p-8 rounded-2xl shadow-md border border-gray-100 hover:shadow-xl transition duration-300">
              <div className="w-12 h-12 bg-accent/10 text-accent rounded-xl flex items-center justify-center mb-6">
                <svg className="w-6 h-6 text-accent" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                  <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path>
                </svg>
              </div>
              <h3 className="text-xl font-bold text-primary mb-3">Associate & Collaborate</h3>
              <p className="text-gray-600 leading-relaxed text-sm">
                Startups and SMBs express interest in campus events as sponsors, mentors, or collaborators — on their own terms.
              </p>
            </div>

            {/* Feature 3 */}
            <div className="bg-white p-8 rounded-2xl shadow-md border border-gray-100 hover:shadow-xl transition duration-300">
              <div className="w-12 h-12 bg-green-50 text-green-600 rounded-xl flex items-center justify-center mb-6">
                <svg className="w-6 h-6 text-green-600" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                  <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M9 12l2 2 4-4m6 2a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                </svg>
              </div>
              <h3 className="text-xl font-bold text-primary mb-3">Close the Deal</h3>
              <p className="text-gray-600 leading-relaxed text-sm">
                Matched parties connect, finalize association terms and capture deal closure — all within the platform.
              </p>
            </div>
          </div>
        </section>

        {/* NEW SECTION 1 — ABOUT THE SERVICE */}
        <section className="bg-white py-20 border-t border-slate-100">
          <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
            <div className="grid grid-cols-1 lg:grid-cols-12 gap-12 lg:gap-20">
              {/* Left Column (text) */}
              <div className="lg:col-span-6 flex flex-col justify-center">
                <span className="text-xs font-bold tracking-widest text-accent uppercase mb-2 block">
                  ABOUT THE SERVICE
                </span>
                <h2 className="text-3xl font-bold text-primary mb-4 leading-tight">
                  Where Campus Energy Meets Startup Ambition
                </h2>
                <p className="text-sm font-semibold text-gray-500 mb-6">
                  Powered by Millionminds UpSkill Academy
                </p>
                <div className="space-y-4">
                  <p className="text-slate-600 text-sm leading-relaxed mb-4">
                    ELEVATE: TechFests@Campus bridges the gap between India's 
                    startup ecosystem and campus knowledge events. Startups and 
                    SMBs discover curated hackathons, ideathons, workshops and 
                    seminars — and associate with them as sponsors, mentors, 
                    or collaborators.
                  </p>
                  <p className="text-slate-600 text-sm leading-relaxed mb-4">
                    Campuses get real-world industry connect, corporate visibility 
                    and meaningful engagement beyond the classroom. Corporates get 
                    access to fresh talent, innovation energy and brand presence 
                    on campus.
                  </p>
                  <p className="text-slate-600 text-sm leading-relaxed mb-4">
                    ELEVATE is part of the Millionminds UpSkill Academy — a 
                    new-age platform built to create meaningful knowledge exchange 
                    between India's campuses and its startup ecosystem.
                  </p>
                </div>
              </div>

              {/* Right Column (stats grid) */}
              <div className="lg:col-span-6 flex items-center">
                <div className="grid grid-cols-1 sm:grid-cols-2 gap-6 w-full">
                  {/* Stat 1 */}
                  <div className="bg-slate-50 rounded-xl p-6 text-center border border-slate-100">
                    <div className="text-3xl font-bold text-primary">500+</div>
                    <div className="text-sm text-slate-500">Campuses Listed</div>
                  </div>
                  {/* Stat 2 */}
                  <div className="bg-slate-50 rounded-xl p-6 text-center border border-slate-100">
                    <div className="text-3xl font-bold text-primary">1000+</div>
                    <div className="text-sm text-slate-500">Startups & SMBs</div>
                  </div>
                  {/* Stat 3 */}
                  <div className="bg-slate-50 rounded-xl p-6 text-center border border-slate-100">
                    <div className="text-3xl font-bold text-primary">50+</div>
                    <div className="text-sm text-slate-500">Cities Covered</div>
                  </div>
                  {/* Stat 4 */}
                  <div className="bg-slate-50 rounded-xl p-6 text-center border border-slate-100">
                    <div className="text-3xl font-bold text-primary">Pan-India</div>
                    <div className="text-sm text-slate-500">Reach</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>

        {/* NEW SECTION 2 — CTA BANNER */}
        <section className="bg-[#1e3a5f] py-16 text-center text-white">
          <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
            <h2 className="text-white font-bold text-3xl mb-4">
              Ready to Elevate Your Campus Events?
            </h2>
            <p className="text-gray-300 text-lg mb-8">
              Join ELEVATE today and connect with India's most active startup ecosystem.
            </p>
            <div className="flex flex-col sm:flex-row justify-center items-center gap-4">
              <Link
                to="/register?role=CAMPUS"
                className="bg-white text-primary font-bold px-6 py-3 rounded-lg hover:bg-gray-150 transition inline-block text-center shadow-sm"
              >
                List Your Programme
              </Link>
              <Link
                to="/register?role=CORPORATE"
                className="bg-accent text-white font-bold px-6 py-3 rounded-lg hover:bg-orange-600 transition inline-block text-center shadow-sm"
              >
                Find Events to Sponsor
              </Link>
            </div>
          </div>
        </section>

        {/* NEW SECTION 3 — HOW IT WORKS */}
        <section className="bg-slate-50 py-20 text-center">
          <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
            <span className="text-xs font-bold tracking-widest text-accent uppercase mb-2 block">
              HOW IT WORKS
            </span>
            <h2 className="text-3xl font-bold text-primary mb-4">How It Works</h2>
            <p className="text-lg text-slate-600 mb-12 max-w-2xl mx-auto">
              From listing to deal closure — everything in one place.
            </p>

            <div className="flex flex-col md:flex-row items-center md:items-stretch justify-between gap-6 overflow-x-auto pb-4 md:pb-0">
              {/* Step 1 */}
              <div className="flex-1 min-w-[250px] bg-white rounded-2xl shadow-sm p-6 border border-slate-100 flex flex-col items-start text-left">
                <div className="flex justify-between items-center w-full mb-4">
                  <div className="bg-primary text-white w-8 h-8 rounded-full flex items-center justify-center text-sm font-bold mb-4">
                    01
                  </div>
                  <span className="text-2xl">🎓</span>
                </div>
                <h3 className="text-lg font-bold text-slate-900 mb-2">Campus Lists Event</h3>
                <p className="text-slate-600 text-sm leading-relaxed">
                  Colleges and universities list their upcoming hackathons, workshops, ideathons and seminars with full details.
                </p>
              </div>

              {/* Arrow 1 */}
              <div className="hidden md:flex items-center text-slate-300 text-2xl font-bold select-none">
                →
              </div>

              {/* Step 2 */}
              <div className="flex-1 min-w-[250px] bg-white rounded-2xl shadow-sm p-6 border border-slate-100 flex flex-col items-start text-left">
                <div className="flex justify-between items-center w-full mb-4">
                  <div className="bg-primary text-white w-8 h-8 rounded-full flex items-center justify-center text-sm font-bold mb-4">
                    02
                  </div>
                  <span className="text-2xl">🔍</span>
                </div>
                <h3 className="text-lg font-bold text-slate-900 mb-2">Corporates Discover</h3>
                <p className="text-slate-600 text-sm leading-relaxed">
                  Startups and SMBs browse the curated pool of campus events and filter by domain, location, scale and type.
                </p>
              </div>

              {/* Arrow 2 */}
              <div className="hidden md:flex items-center text-slate-300 text-2xl font-bold select-none">
                →
              </div>

              {/* Step 3 */}
              <div className="flex-1 min-w-[250px] bg-white rounded-2xl shadow-sm p-6 border border-slate-100 flex flex-col items-start text-left">
                <div className="flex justify-between items-center w-full mb-4">
                  <div className="bg-primary text-white w-8 h-8 rounded-full flex items-center justify-center text-sm font-bold mb-4">
                    03
                  </div>
                  <span className="text-2xl">🤝</span>
                </div>
                <h3 className="text-lg font-bold text-slate-900 mb-2">Express Interest</h3>
                <p className="text-slate-600 text-sm leading-relaxed">
                  Corporates shortlist events and express their intent to associate — as sponsors, mentors or collaborators.
                </p>
              </div>

              {/* Arrow 3 */}
              <div className="hidden md:flex items-center text-slate-300 text-2xl font-bold select-none">
                →
              </div>

              {/* Step 4 */}
              <div className="flex-1 min-w-[250px] bg-white rounded-2xl shadow-sm p-6 border border-slate-100 flex flex-col items-start text-left">
                <div className="flex justify-between items-center w-full mb-4">
                  <div className="bg-primary text-white w-8 h-8 rounded-full flex items-center justify-center text-sm font-bold mb-4">
                    04
                  </div>
                  <span className="text-2xl">🚀</span>
                </div>
                <h3 className="text-lg font-bold text-slate-900 mb-2">Close the Deal</h3>
                <p className="text-slate-600 text-sm leading-relaxed">
                  Matched parties connect offline, finalise terms and capture deal closure with deliverables on the platform.
                </p>
              </div>
            </div>
          </div>
        </section>

        {/* NEW SECTION 4 — ABOUT MILLIONMINDS */}
        <section className="bg-slate-900 text-white py-20 text-center">
          <div className="max-w-3xl mx-auto px-4 sm:px-6 lg:px-8">
            <div className="bg-white rounded-xl px-4 py-2 inline-block mb-6 shadow-sm">
              <img src="/millionminds-logo.png" className="h-10 w-auto object-contain" alt="Millionminds" />
            </div>

            <h2 className="text-3xl font-bold text-white mb-4">About Millionminds</h2>

            <div className="space-y-4 text-slate-300 text-sm leading-relaxed mb-6">
              <p>
                Millionminds is a skilling platform dedicated to fostering 
                tech upskilling, innovation, entrepreneurship, and employability 
                amongst campus students across India. We bridge the gap between 
                what employers seek from campus freshers and what students 
                actually learn.
              </p>
              <p>
                Our programmes span AI literacy, career upskilling, job 
                placements, internships, and industry R&D projects — all 
                delivered in partnership with domain experts, mentors, and 
                campus institutions.
              </p>
            </div>

            <p className="text-accent font-semibold italic text-lg mt-4 mb-6">
              Skilling Platform: Harnessing Unexplored Talent. A Change Agent.
            </p>

            <a
              href="https://www.millionminds.in"
              target="_blank"
              rel="noopener noreferrer"
              className="mt-6 px-6 py-3 bg-primary text-white rounded-lg font-semibold hover:bg-blue-500 transition-colors inline-block"
            >
              Visit Millionminds →
            </a>
          </div>
        </section>

        {/* NEW SECTION 5 — CONTACT US */}
        <section className="bg-white py-20 text-center border-b border-slate-100">
          <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
            <span className="text-xs font-bold tracking-widest text-accent uppercase mb-2 block">
              GET IN TOUCH
            </span>
            <h2 className="text-3xl font-bold text-primary mb-4">Get In Touch</h2>
            <p className="text-lg text-slate-600 mb-12 max-w-2xl mx-auto">
              Have questions about ELEVATE? We'd love to hear from you.
            </p>

            <div className="grid grid-cols-1 lg:grid-cols-2 gap-12 text-left">
              {/* Left column — Contact info cards */}
              <div className="flex flex-col gap-4 justify-center">
                <div className="flex items-center gap-4 p-4 bg-slate-50 rounded-xl border border-slate-100">
                  <span className="text-2xl">🌐</span>
                  <div>
                    <div className="text-xs text-slate-500 font-medium">Website</div>
                    <a
                      href="https://www.millionminds.in"
                      target="_blank"
                      rel="noopener noreferrer"
                      className="text-sm font-semibold text-primary hover:text-accent transition"
                    >
                      www.millionminds.in
                    </a>
                  </div>
                </div>

                <div className="flex items-center gap-4 p-4 bg-slate-50 rounded-xl border border-slate-100">
                  <span className="text-2xl">📧</span>
                  <div>
                    <div className="text-xs text-slate-500 font-medium">Email</div>
                    <a
                      href="mailto:info@millionminds.in"
                      className="text-sm font-semibold text-primary hover:text-accent transition"
                    >
                      info@millionminds.in
                    </a>
                  </div>
                </div>

                <div className="flex items-center gap-4 p-4 bg-slate-50 rounded-xl border border-slate-100">
                  <span className="text-2xl">🏢</span>
                  <div>
                    <div className="text-xs text-slate-500 font-medium">Platform</div>
                    <div className="text-sm font-semibold text-primary">ELEVATE: TechFests@Campus</div>
                    <div className="text-xs text-slate-500">Powered by Millionminds UpSkill Academy</div>
                  </div>
                </div>
              </div>

              {/* Right column — Form */}
              <div className="bg-slate-50 p-8 rounded-2xl border border-slate-100">
                <form
                  onSubmit={(e) => {
                    e.preventDefault();
                    const name = e.target.elements.fullName.value;
                    const email = e.target.elements.email.value;
                    const message = e.target.elements.message.value;
                    const subject = encodeURIComponent("ELEVATE Enquiry");
                    const body = encodeURIComponent(`Full Name: ${name}\nEmail: ${email}\n\nMessage:\n${message}`);
                    window.location.href = `mailto:info@millionminds.in?subject=${subject}&body=${body}`;
                  }}
                  className="space-y-4"
                >
                  <div>
                    <label htmlFor="fullName" className="block text-sm font-semibold text-slate-700 mb-1">
                      Full Name
                    </label>
                    <input
                      type="text"
                      id="fullName"
                      name="fullName"
                      required
                      className="w-full px-4 py-2 bg-white border border-slate-200 rounded-lg focus:outline-none focus:ring-2 focus:ring-primary/20 focus:border-primary text-slate-900 text-sm"
                      placeholder="John Doe"
                    />
                  </div>
                  <div>
                    <label htmlFor="email" className="block text-sm font-semibold text-slate-700 mb-1">
                      Email Address
                    </label>
                    <input
                      type="email"
                      id="email"
                      name="email"
                      required
                      className="w-full px-4 py-2 bg-white border border-slate-200 rounded-lg focus:outline-none focus:ring-2 focus:ring-primary/20 focus:border-primary text-slate-900 text-sm"
                      placeholder="john@example.com"
                    />
                  </div>
                  <div>
                    <label htmlFor="message" className="block text-sm font-semibold text-slate-700 mb-1">
                      Message
                    </label>
                    <textarea
                      id="message"
                      name="message"
                      rows="4"
                      required
                      className="w-full px-4 py-2 bg-white border border-slate-200 rounded-lg focus:outline-none focus:ring-2 focus:ring-primary/20 focus:border-primary text-slate-900 text-sm resize-none"
                      placeholder="Your message details here..."
                    />
                  </div>
                  <button
                    type="submit"
                    className="w-full bg-primary text-white rounded-lg font-bold py-3 hover:bg-primary-dark transition text-sm shadow-sm"
                  >
                    Send Message
                  </button>
                </form>
              </div>
            </div>
          </div>
        </section>
      </main>

      {/* NEW FOOTER */}
      <footer className="bg-slate-900 text-slate-400 py-12 border-t border-slate-800">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
          <div className="grid grid-cols-1 md:grid-cols-3 gap-8 py-12">
            {/* Left */}
            <div className="flex flex-col items-start">
              <div className="bg-white rounded px-3 py-1 inline-block h-8 mb-2">
                <img src="/millionminds-logo.png" className="h-6 w-auto object-contain" alt="Millionminds" />
              </div>
              <p className="text-slate-400 text-sm mt-2">ELEVATE: TechFests@Campus</p>
              <p className="text-slate-500 text-xs mt-1">© 2026 Millionminds. All rights reserved.</p>
            </div>

            {/* Center */}
            <div>
              <h4 className="text-white font-semibold mb-3">Quick Links</h4>
              <ul className="space-y-2 text-sm">
                <li>
                  <Link to="/" className="text-slate-400 hover:text-white transition">
                    Home
                  </Link>
                </li>
                <li>
                  <Link to="/register?role=CAMPUS" className="text-slate-400 hover:text-white transition">
                    Register as Campus
                  </Link>
                </li>
                <li>
                  <Link to="/register?role=CORPORATE" className="text-slate-400 hover:text-white transition">
                    Register as Corporate
                  </Link>
                </li>
                <li>
                  <Link to="/login" className="text-slate-400 hover:text-white transition">
                    Login
                  </Link>
                </li>
              </ul>
            </div>

            {/* Right */}
            <div>
              <h4 className="text-white font-semibold mb-3">Platform</h4>
              <ul className="space-y-2 text-sm text-slate-400">
                <li>Browse Knowledge Events</li>
                <li>Express Interest</li>
                <li>Close Deals</li>
                <li>Admin Dashboard</li>
                <li>Powered by Millionminds</li>
              </ul>
            </div>
          </div>

          <div className="border-t border-slate-800 pt-4 mt-8 text-center">
            <p className="text-slate-600 text-xs">
              Built with ❤️ for India's Startup Ecosystem · Millionminds UpSkill Academy
            </p>
          </div>
        </div>
      </footer>
    </div>
  );
};

export default LandingPage;
