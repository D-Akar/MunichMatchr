<script setup>
import { ref, onMounted } from 'vue'
import HeaderBlock from '@/components/HeaderBlock.vue'
import { Disclosure, DisclosureButton, DisclosurePanel } from '@headlessui/vue'
import { Dialog, TransitionRoot } from '@headlessui/vue'
import { XMarkIcon } from '@heroicons/vue/24/outline'
import { ChevronDownIcon, PlusIcon, MinusIcon } from '@heroicons/vue/20/solid'

//mock events
const upcomingEvents = ref([
  { id: 1, name: 'MILF Parade', date: '2024-12-05', location: 'Community Hall' },
  { id: 2, name: 'Baking Hour', date: '2024-12-12', location: 'Kitchen Studio' }
]);



// fetching (mock)
const points = ref(0) //points
const availableGifts = ref([
  { id: 3, name: 'Starbucks Coupon', pointsCost: 50, description: '50 % discount for your coffee order', redeemed: false },
  { id: 2, name: 'Book Voucher', pointsCost: 100, description: '20% discount at Hugendubel ', redeemed: false },
  { id: 1, name: 'Social Work', pointsCost: points, description: 'Redeem all your point as a social work credit.', redeemed: false },
  { id: 4, name: 'Käfer Gift Card', pointsCost: 150, description: '10% off of luxurious goods', redeemed: true }
])

//mock past events
const pastEvents = ref([
  { id: 1, name: 'Story Telling', date: '2024-10-15', location: 'Library' },
  { id: 2, name: 'Game Night', date: '2024-11-01', location: 'Recreation Center' }
]);
// cat
const mobileFiltersOpen = ref(false)

// mock CHANGE!!!!!
const redeemGift = (giftId) => {
  const gift = availableGifts.value.find(g => g.id === giftId)
  if (gift && points.value >= gift.pointsCost && !gift.redeemed) {
    points.value -= gift.pointsCost
    gift.redeemed = true
  }
}

onMounted(async () => {
  try {
    const userEmail = localStorage.getItem('userEmail')
    if (!userEmail) {
      console.error('User email not found in localStorage')
      return
    }

    const response = await fetch(`http://localhost:8080/user/get/${userEmail}`)
    const userData = await response.json()
    points.value = userData.coins
  } catch (error) {
    console.error('Error fetching user points:', error)
  }
})
</script>

<template>
  <main class="flex h-full flex-col">
    <HeaderBlock />

    <div class="bg-white">
      <div>
        <TransitionRoot as="template" :show="mobileFiltersOpen">
          <Dialog class="relative z-40 lg:hidden" @close="mobileFiltersOpen = false">
            <TransitionChild as="template" enter="transition-opacity ease-linear duration-300" enter-from="opacity-0"
              enter-to="opacity-100" leave="transition-opacity ease-linear duration-300" leave-from="opacity-100"
              leave-to="opacity-0">
              <div class="fixed inset-0 bg-black/25" />
            </TransitionChild>

            <div class="fixed inset-0 z-40 flex">
              <TransitionChild as="template" enter="transition ease-in-out duration-300 transform"
                enter-from="translate-x-full" enter-to="translate-x-0"
                leave="transition ease-in-out duration-300 transform" leave-from="translate-x-0"
                leave-to="translate-x-full">
                <DialogPanel class="relative ml-auto max-w-xs flex-col overflow-y-auto bg-white py-4 pb-12 shadow-xl">
                  <div class="flex items-center justify-between px-4">
                    <h2 class="text-lg font-medium text-gray-900">Filters</h2>
                    <button type="button"
                      class="-mr-2 flex h-10 w-10 items-center justify-center rounded-md bg-white p-2 text-gray-400"
                      @click="mobileFiltersOpen = false">
                      <span class="sr-only">Close menu</span>
                      <XMarkIcon class="h-6 w-6" aria-hidden="true" />
                    </button>
                  </div>
                </DialogPanel>
              </TransitionChild>
            </div>
          </Dialog>
        </TransitionRoot>

        <main class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
          <div class="flex items-baseline justify-between border-b border-gray-200 pb-6 pt-2">
            <h1 class="text-4xl font-bold tracking-tight text-gray-900">Your Benefits</h1>
            <div class="text-lg font-semibold text-gray-700">You have {{ points }} points</div>
          </div>

          <section aria-labelledby="gifts-heading" class="pb-24 pt-6">
            <h2 id="gifts-heading" class="sr-only">Gifts</h2>


            <!-- available gifts and redeemed gifts -->
            <div class="grid grid-cols-1 gap-x-8 gap-y-10 lg:grid-cols-3">
              <div class="lg:col-span-3 space-y-6">
                <div>
                  <h2 class="text-2xl font-bold text-gray-900 mb-4">Available Gifts</h2>
                  <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                    <div v-for="gift in availableGifts.filter(g => !g.redeemed)" :key="gift.id"
                      class="border rounded-lg p-4 shadow-sm bg-white">
                      <h3 class="text-lg font-semibold">{{ gift.name }}</h3>
                      <p class="text-gray-600">{{ gift.description }}</p>
                      <div class="mt-2 text-indigo-600 font-medium">{{ gift.pointsCost }} Points</div>
                      <button @click="redeemGift(gift.id)" :disabled="points < gift.pointsCost"
                        class="mt-4 w-full text-white bg-indigo-600 hover:bg-indigo-700 focus:ring-indigo-500 focus:outline-none focus:ring-2 focus:ring-offset-2 rounded-md px-4 py-2">
                        Redeem
                      </button>
                    </div>
                  </div>
                </div>
                <div>
                  <h2 class="text-2xl font-bold text-gray-900 mt-8 mb-4">Redeemed Gifts</h2>
                  <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                    <div v-for="gift in availableGifts.filter(g => g.redeemed)" :key="gift.id"
                      class="border rounded-lg p-4 shadow-sm bg-gray-100">
                      <h3 class="text-lg font-semibold">{{ gift.name }}</h3>
                      <p class="text-gray-600">{{ gift.description }}</p>
                      <div class="mt-2 text-green-600 font-medium">Redeemed</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
          <!-- evsec -->
          <section aria-labelledby="events-heading" class="pb-24 pt-6 border-t border-gray-200">
            <h2 id="events-heading" class="text-2xl font-bold text-gray-900 mb-4">Your Events</h2>

            <!-- upcoming -->
            <div class="border-b border-gray-200 py-4">
              <Disclosure>
                <template #default="{ open }">
                  <DisclosureButton
                    class="flex justify-between items-center w-full bg-white py-3 text-lg font-medium text-gray-900 hover:bg-gray-50 rounded-md px-4">
                    <span>Upcoming Events</span>
                    <ChevronDownIcon :class="{ 'rotate-180': open, 'rotate-0': !open }"
                      class="h-5 w-5 transition-transform duration-300" />
                  </DisclosureButton>
                  <DisclosurePanel>
                    <ul class="space-y-4 pt-4">
                      <li v-for="event in upcomingEvents" :key="event.id"
                        class="border rounded-lg p-4 bg-gray-50 shadow-sm hover:shadow-md transition-shadow">
                        <h3 class="text-lg font-semibold">{{ event.name }}</h3>
                        <p class="text-gray-600">Date: {{ event.date }}</p>
                        <p class="text-gray-600">Location: {{ event.location }}</p>
                      </li>
                    </ul>
                  </DisclosurePanel>
                </template>
              </Disclosure>
            </div>

            <!-- past events -->
            <div class="border-b border-gray-200 py-4 mt-4">
              <Disclosure>
                <template #default="{ open }">
                  <DisclosureButton
                    class="flex justify-between items-center w-full bg-white py-3 text-lg font-medium text-gray-900 hover:bg-gray-50 rounded-md px-4">
                    <span>Past Events</span>
                    <ChevronDownIcon :class="{ 'rotate-180': open, 'rotate-0': !open }"
                      class="h-5 w-5 transition-transform duration-300" />
                  </DisclosureButton>
                  <DisclosurePanel>
                    <ul class="space-y-4 pt-4">
                      <li v-for="event in pastEvents" :key="event.id"
                        class="border rounded-lg p-4 bg-gray-50 shadow-sm hover:shadow-md transition-shadow">
                        <h3 class="text-lg font-semibold">{{ event.name }}</h3>
                        <p class="text-gray-600">Date: {{ event.date }}</p>
                        <p class="text-gray-600">Location: {{ event.location }}</p>
                      </li>
                    </ul>
                  </DisclosurePanel>
                </template>
              </Disclosure>
            </div>
          </section>

        </main>
      </div>
    </div>
  </main>
</template>
