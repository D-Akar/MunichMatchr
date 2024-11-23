<script setup>
import { ref, onMounted } from 'vue'
import HeaderBlock from '@/components/HeaderBlock.vue'
import { Dialog, TransitionRoot } from '@headlessui/vue'
import { XMarkIcon } from '@heroicons/vue/24/outline'
import { ChevronDownIcon, PlusIcon, MinusIcon } from '@heroicons/vue/20/solid'

// fetching (mock)
const points = ref(120) //points
const availableGifts = ref([
  { id: 1, name: 'Coffee Coupon', pointsCost: 50, description: 'Get a free coffee.', redeemed: false },
  { id: 2, name: 'Book Voucher', pointsCost: 100, description: 'Discount on books.', redeemed: false },
  { id: 3, name: 'Gift Mug', pointsCost: 200, description: 'Receive a personalized mug.', redeemed: true },
  { id: 4, name: 'Local Gift Card', pointsCost: 150, description: 'Gift card for local stores.', redeemed: false }
])

// cat
const mobileFiltersOpen = ref(false)

// Mockup function to simulate redeeming a gift
const redeemGift = (giftId) => {
  const gift = availableGifts.value.find(g => g.id === giftId)
  if (gift && points.value >= gift.pointsCost && !gift.redeemed) {
    points.value -= gift.pointsCost
    gift.redeemed = true
  }
}
</script>

<template>
  <main class="flex h-full flex-col">
    <!-- Using the HeaderBlock component for consistent styling -->
    <HeaderBlock />

    <div class="bg-white">
      <div>
        <!-- Mobile filter dialog -->
        <TransitionRoot as="template" :show="mobileFiltersOpen">
          <Dialog class="relative z-40 lg:hidden" @close="mobileFiltersOpen = false">
            <TransitionChild as="template" enter="transition-opacity ease-linear duration-300" enter-from="opacity-0" enter-to="opacity-100" leave="transition-opacity ease-linear duration-300" leave-from="opacity-100" leave-to="opacity-0">
              <div class="fixed inset-0 bg-black/25" />
            </TransitionChild>

            <div class="fixed inset-0 z-40 flex">
              <TransitionChild as="template" enter="transition ease-in-out duration-300 transform" enter-from="translate-x-full" enter-to="translate-x-0" leave="transition ease-in-out duration-300 transform" leave-from="translate-x-0" leave-to="translate-x-full">
                <DialogPanel class="relative ml-auto max-w-xs flex-col overflow-y-auto bg-white py-4 pb-12 shadow-xl">
                  <div class="flex items-center justify-between px-4">
                    <h2 class="text-lg font-medium text-gray-900">Filters</h2>
                    <button type="button" class="-mr-2 flex h-10 w-10 items-center justify-center rounded-md bg-white p-2 text-gray-400" @click="mobileFiltersOpen = false">
                      <span class="sr-only">Close menu</span>
                      <XMarkIcon class="h-6 w-6" aria-hidden="true" />
                    </button>
                  </div>
                </DialogPanel>
              </TransitionChild>
            </div>
          </Dialog>
        </TransitionRoot>

        <!-- Main content -->
        <main class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
          <div class="flex items-baseline justify-between border-b border-gray-200 pb-6 pt-24">
            <h1 class="text-4xl font-bold tracking-tight text-gray-900">Your Benefits</h1>
            <div class="text-lg font-semibold text-gray-700">You have {{ points }} points</div>
          </div>

          <section aria-labelledby="gifts-heading" class="pb-24 pt-6">
            <h2 id="gifts-heading" class="sr-only">Gifts</h2>


<!-- Displaying available and redeemed gifts -->
            <div class="grid grid-cols-1 gap-x-8 gap-y-10 lg:grid-cols-3">
              <div class="lg:col-span-3 space-y-6">
                <!-- Available Gifts -->
                <div>
                  <h2 class="text-2xl font-bold text-gray-900 mb-4">Available Gifts</h2>
                  <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                    <div v-for="gift in availableGifts.filter(g => !g.redeemed)" :key="gift.id" class="border rounded-lg p-4 shadow-sm bg-white">
                      <h3 class="text-lg font-semibold">{{ gift.name }}</h3>
                      <p class="text-gray-600">{{ gift.description }}</p>
                      <div class="mt-2 text-indigo-600 font-medium">{{ gift.pointsCost }} Points</div>
                      <button 
                        @click="redeemGift(gift.id)"
                        :disabled="points < gift.pointsCost"
                        class="mt-4 w-full text-white bg-indigo-600 hover:bg-indigo-700 focus:ring-indigo-500 focus:outline-none focus:ring-2 focus:ring-offset-2 rounded-md px-4 py-2"
                      >
                        Redeem
                      </button>
                    </div>
                  </div>
                </div>

                <!-- Redeemed Gifts -->
                <div>
                  <h2 class="text-2xl font-bold text-gray-900 mt-8 mb-4">Redeemed Gifts</h2>
                  <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                    <div v-for="gift in availableGifts.filter(g => g.redeemed)" :key="gift.id" class="border rounded-lg p-4 shadow-sm bg-gray-100">
                      <h3 class="text-lg font-semibold">{{ gift.name }}</h3>
                      <p class="text-gray-600">{{ gift.description }}</p>
                      <div class="mt-2 text-green-600 font-medium">Redeemed</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
        </main>
      </div>
    </div>
  </main>
</template>


